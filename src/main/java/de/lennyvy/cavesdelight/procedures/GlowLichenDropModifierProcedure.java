package de.lennyvy.cavesdelight.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

import de.lennyvy.cavesdelight.init.CavesdelightModItems;

@EventBusSubscriber
public class GlowLichenDropModifierProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getState(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		execute(null, world, x, y, z, blockstate, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		Entity player = null;
		double random = 0;
		ItemStack rawGlowLichen = ItemStack.EMPTY;
		BlockState glowLichenBlock = Blocks.AIR.defaultBlockState();
		random = Mth.nextDouble(RandomSource.create(), 1, 3);
		player = entity;
		glowLichenBlock = blockstate;
		rawGlowLichen = new ItemStack(CavesdelightModItems.RAW_GLOW_LICHEN.get()).copy();
		rawGlowLichen.setCount((int) random);
		if (player instanceof Player && (player instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("farmersdelight:tools/knives")))
				&& glowLichenBlock.getBlock() == Blocks.GLOW_LICHEN) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, rawGlowLichen);
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}
}