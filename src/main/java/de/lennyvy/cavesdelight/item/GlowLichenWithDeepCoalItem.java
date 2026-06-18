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

import java.util.List;

public class GlowLichenWithDeepCoalItem extends Item {

    public GlowLichenWithDeepCoalItem() {
        super(new Properties().stacksTo(16).food(new FoodProperties.Builder()
            .nutrition(12)
            .saturationModifier(1.5f)
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 1800, 0), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 3600, 0), 1.0f)
            .build()));
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context,
                                 List<Component> tooltip, TooltipFlag flag) {
        TextUtils.addFoodEffectTooltip(stack, tooltip::add, 1.0F, context.tickRate());
    }
}