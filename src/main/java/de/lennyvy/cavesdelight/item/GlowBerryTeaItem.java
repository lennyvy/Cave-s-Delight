package de.lennyvy.cavesdelight.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.TooltipFlag;

import vectorwing.farmersdelight.common.utility.TextUtils;

import java.util.List;

public class GlowBerryTeaItem extends Item {
	public GlowBerryTeaItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(0).saturationModifier(0f).alwaysEdible()
				.effect(() -> new MobEffectInstance(MobEffects.GLOWING, 1800, 0), 1.0f).build()));
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