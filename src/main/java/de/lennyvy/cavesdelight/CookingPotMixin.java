package de.lennyvy.cavesdelight.mixin;

import de.lennyvy.cavesdelight.util.CookingPotCaches;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomModelData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vectorwing.farmersdelight.common.block.entity.CookingPotBlockEntity;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Mixin(CookingPotBlockEntity.class)
public class CookingPotMixin {

    private static final int OUTPUT_SLOT = 8;
    private static final Map<CookingPotBlockEntity, CookingPotCaches> CACHE = new ConcurrentHashMap<>();

    @Inject(method = "cookingTick", at = @At("HEAD"), cancellable = true)
    private static void cavesdelight$blockIfMismatch(Level level, BlockPos pos, BlockState state,
                                                      CookingPotBlockEntity self, CallbackInfo ci) {
        ItemStackHandler inv = self.getInventory();
        ItemStack output = inv.getStackInSlot(OUTPUT_SLOT);

        if (output.isEmpty()) return;

        CustomModelData outputCmd = output.get(DataComponents.CUSTOM_MODEL_DATA);

        CustomModelData inputCmd = null;
        for (int i = 0; i <= 5; i++) {
            ItemStack ingredient = inv.getStackInSlot(i);
            if (!ingredient.isEmpty()) {
                inputCmd = ingredient.get(DataComponents.CUSTOM_MODEL_DATA);
                if (inputCmd != null) break;
            }
        }
        
        if (!Objects.equals(outputCmd, inputCmd)) {
            ci.cancel();
        }
    }

    @Inject(method = "setRemoved", at = @At("HEAD"))
	private void cavesdelight$clearCache(CallbackInfo ci) {
	    CACHE.remove((CookingPotBlockEntity) (Object) this);
	}

    @Inject(method = "cookingTick", at = @At("HEAD"))
    private static void cavesdelight$captureData(Level level, BlockPos pos, BlockState state,
                                                  CookingPotBlockEntity self, CallbackInfo ci) {
                                                  	
        if (ci.isCancelled()) return;

        ItemStackHandler inv = self.getInventory();

        CustomModelData foundCmd = null;
        for (int i = 0; i <= 5; i++) {
            ItemStack ingredient = inv.getStackInSlot(i);
            if (!ingredient.isEmpty()) {
                foundCmd = ingredient.get(DataComponents.CUSTOM_MODEL_DATA);
                if (foundCmd != null) break;
            }
        }

        ItemStack outputCopy = inv.getStackInSlot(OUTPUT_SLOT).copy();
        CACHE.put(self, new CookingPotCaches(foundCmd, outputCopy));
    }

    @Inject(method = "cookingTick", at = @At("RETURN"))
    private static void cavesdelight$applyCmdIfCooked(Level level, BlockPos pos, BlockState state,
                                                       CookingPotBlockEntity self, CallbackInfo ci) {
        CookingPotCaches data = CACHE.remove(self);
        if (data == null) return;

        ItemStack currentOutput = self.getInventory().getStackInSlot(OUTPUT_SLOT);
        ItemStack previousOutput = data.previousOutput;

        boolean outputChanged = false;
        if (previousOutput.isEmpty() != currentOutput.isEmpty()) {
            outputChanged = true;
        } else if (!previousOutput.isEmpty() && !currentOutput.isEmpty()) {
            if (previousOutput.getItem() != currentOutput.getItem()
                    || previousOutput.getCount() != currentOutput.getCount()) {
                outputChanged = true;
            }
        }

        if (outputChanged && data.cmd != null && !currentOutput.isEmpty()) {
            currentOutput.set(DataComponents.CUSTOM_MODEL_DATA, data.cmd);
        }
    }
}