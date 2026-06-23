package de.lennyvy.cavesdelight.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import de.lennyvy.cavesdelight.init.CavesdelightModMobEffects;

import vectorwing.farmersdelight.common.utility.TextUtils;

import java.util.List;


public class SmallShimmeringMushroomSliceItem extends Item {
	public SmallShimmeringMushroomSliceItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.5f)
			.effect(() -> new MobEffectInstance(MobEffects.DARKNESS, 100, 0), 1.0f)
			.effect(() -> new MobEffectInstance(CavesdelightModMobEffects.ECHO_SIGHT, 200, 3), 1.0f).build()));
	}

	 @Override
    public void appendHoverText(ItemStack stack, TooltipContext context,
                                 List<Component> tooltip, TooltipFlag flag) {
        TextUtils.addFoodEffectTooltip(stack, tooltip::add, 1.0F, context.tickRate());
    }
}