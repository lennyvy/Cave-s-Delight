package de.lennyvy.cavesdelight.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.component.CustomModelData;

import vectorwing.farmersdelight.common.block.entity.CookingPotBlockEntity;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class CookingPotColorTransfer {

    @SubscribeEvent
    public static void onRightClick(PlayerInteractEvent.RightClickBlock event) {

        var level = event.getLevel();
        var pos = event.getPos();

        if (!(level.getBlockEntity(pos) instanceof CookingPotBlockEntity pot))
            return;
            
        var inv = pot.getInventory();

        ItemStack input = inv.getStackInSlot(0);
        ItemStack output = inv.getStackInSlot(2);

        if (input.isEmpty() || output.isEmpty()) return;

        CustomModelData data = input.get(DataComponents.CUSTOM_MODEL_DATA);

        if (data != null) {
            output.set(DataComponents.CUSTOM_MODEL_DATA, data);
        }
    }
}