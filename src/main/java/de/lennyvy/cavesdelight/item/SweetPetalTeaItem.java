package de.lennyvy.cavesdelight.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import vectorwing.farmersdelight.common.utility.TextUtils;

import java.util.List;

public class SweetPetalTeaItem extends Item {
	public SweetPetalTeaItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(0).saturationModifier(0f).alwaysEdible()
				.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1800, 0), 1.0f)
				.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1800, 0), 1.0f).build()));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.DRINK;
	}

	@Override
	public int getUseDuration(ItemStack itemstack, LivingEntity livingEntity) {
		return 16;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = new ItemStack(Items.GLASS_BOTTLE);
		super.finishUsingItem(itemstack, world, entity);
		if (itemstack.isEmpty()) {
			return retval;
		} else {
			if (entity instanceof Player player && !player.getAbilities().instabuild) {
				if (!player.getInventory().add(retval))
					player.drop(retval, false);
			}
			return itemstack;
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context,
								List<Component> tooltip, TooltipFlag flag) {
		TextUtils.addFoodEffectTooltip(stack, tooltip::add, 1.0F, context.tickRate());
	}
}