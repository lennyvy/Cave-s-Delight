package de.lennyvy.cavesdelight.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import java.util.Iterator;

import de.lennyvy.cavesdelight.init.CavesdelightModItems;

@EventBusSubscriber
public class SpiderDropModificationProcedureProcedure {

	@SubscribeEvent
	public static void onLivingDrops(LivingDropsEvent event) {
		LivingEntity entity = event.getEntity();
		if (!(entity instanceof Spider || entity instanceof CaveSpider)) {
			return;
		}
		Entity sourceentity = event.getSource().getEntity();
		boolean hasKnife = sourceentity instanceof Player player
				&& player.getMainHandItem().is(ItemTags.create(ResourceLocation.parse("farmersdelight:tools/knives")));

		Iterator<ItemEntity> iterator = event.getDrops().iterator();
		while (iterator.hasNext()) {
			ItemEntity itemEntity = iterator.next();
			if (itemEntity.getItem().getItem() == Items.STRING) {
				iterator.remove();
			}
		}

		int silkCount = Mth.nextInt(RandomSource.create(), 2, 4);
		ItemStack silkStack = new ItemStack(CavesdelightModItems.SPIDER_SILK.get(), silkCount);
		Level level = entity.level();
		event.getDrops().add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), silkStack));

		if (hasKnife) {
			int legCount = Mth.nextInt(RandomSource.create(), 1, 2);
			ItemStack legStack = new ItemStack(CavesdelightModItems.SPIDER_LEG.get(), legCount);
			event.getDrops().add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), legStack));
		}
	}
}