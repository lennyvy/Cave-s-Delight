package de.lennyvy.cavesdelight.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.List;

@JeiPlugin
public class CavesdelightModCustomJeiInformation implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return ResourceLocation.parse("cavesdelight:information");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addIngredientInfo(List.of(new ItemStack(CavesdelightModItems.LEEK_SEEDS.get()), new ItemStack(CavesdelightModItems.LEEK.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.cavesdelight.leek_info"));
	}
}