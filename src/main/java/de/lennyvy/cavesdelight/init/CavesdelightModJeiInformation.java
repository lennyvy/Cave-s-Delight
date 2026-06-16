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
public class CavesdelightModJeiInformation implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return ResourceLocation.parse("cavesdelight:information");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addIngredientInfo(List.of(new ItemStack(CavesdelightModItems.RAW_AXOLOTL_HAM.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.cavesdelight.axolotl_ham_info"));
		registration.addIngredientInfo(List.of(new ItemStack(CavesdelightModBlocks.CHESS_FLOWER.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.cavesdelight.chess_flower_info"));
		registration.addIngredientInfo(List.of(new ItemStack(CavesdelightModItems.RAW_GLOW_LICHEN.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.cavesdelight.glow_lichen_info"));
	}
}