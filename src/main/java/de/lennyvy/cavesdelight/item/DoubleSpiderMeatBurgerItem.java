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

import vectorwing.farmersdelight.common.utility.TextUtils;
import vectorwing.farmersdelight.common.registry.ModEffects;

import java.util.List;

public class DoubleSpiderMeatBurgerItem extends Item {
	public DoubleSpiderMeatBurgerItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(19).saturationModifier(0.85f)
			.effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 4800, 0), 1.0f).build()));
	}
	
	@Override
    public void appendHoverText(ItemStack stack, TooltipContext context,
                                 List<Component> tooltip, TooltipFlag flag) {
        TextUtils.addFoodEffectTooltip(stack, tooltip::add, 1.0F, context.tickRate());
    }
}