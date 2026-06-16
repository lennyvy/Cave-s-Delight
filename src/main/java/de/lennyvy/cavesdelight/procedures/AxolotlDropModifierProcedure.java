package de.lennyvy.cavesdelight.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
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
public class AxolotlDropModifierProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		Entity axolotl = null;
		Entity player = null;
		double random = 0;
		double axolotl_color = 0;
		ItemStack ham = ItemStack.EMPTY;
		axolotl = entity;
		player = sourceentity;
		if (player instanceof Player && axolotl instanceof Axolotl) {
			if ((player instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("farmersdelight:tools/knives")))) {
				random = Mth.nextDouble(RandomSource.create(), 2, 4);
				if (!axolotl.isOnFire()) {
					ham = new ItemStack(CavesdelightModItems.RAW_AXOLOTL_HAM.get()).copy();
					ham.setCount((int) random);
					if (entity instanceof net.minecraft.world.entity.animal.axolotl.Axolotl _axl) {
						ham.set(net.minecraft.core.component.DataComponents.CUSTOM_MODEL_DATA, new net.minecraft.world.item.component.CustomModelData(_axl.getVariant().getId()));
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ham);
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				} else {
					ham = new ItemStack(CavesdelightModItems.COOKED_AXOLOTL_HAM.get()).copy();
					ham.setCount((int) random);
					if (entity instanceof net.minecraft.world.entity.animal.axolotl.Axolotl _axl) {
						ham.set(net.minecraft.core.component.DataComponents.CUSTOM_MODEL_DATA, new net.minecraft.world.item.component.CustomModelData(_axl.getVariant().getId()));
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ham);
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
		}
	}
}