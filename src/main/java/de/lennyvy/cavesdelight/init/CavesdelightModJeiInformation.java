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
		registration.addIngredientInfo(List.of(new ItemStack(CavesdelightModItems.RAW_AXOLOTL_HAM.get()), new ItemStack(CavesdelightModItems.AXOLOTL_HIDE.get()), new ItemStack(CavesdelightModItems.SPIDER_LEG.get())), VanillaTypes.ITEM_STACK,
				Component.translatable("jei.cavesdelight.axolotl_ham_info"));
		registration.addIngredientInfo(List.of(new ItemStack(CavesdelightModBlocks.CHESS_FLOWER.get()), new ItemStack(CavesdelightModBlocks.HYACINTH_FLOWER.get())), VanillaTypes.ITEM_STACK,
				Component.translatable("jei.cavesdelight.chess_flower_info"));
		registration.addIngredientInfo(List.of(new ItemStack(CavesdelightModItems.RAW_GLOW_LICHEN.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.cavesdelight.glow_lichen_info"));
		registration.addIngredientInfo(List.of(new ItemStack(CavesdelightModItems.DEEP_COAL.get()), new ItemStack(CavesdelightModBlocks.DEEP_COAL_ORE.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.cavesdelight.deep_coal_info"));
		registration.addIngredientInfo(List.of(new ItemStack(CavesdelightModBlocks.SHIMMERING_MUSHROOM.get()), new ItemStack(CavesdelightModBlocks.SMALL_SHIMMERING_MUSHROOMS.get())), VanillaTypes.ITEM_STACK,
				Component.translatable("jei.cavesdelight.shimmering_mushroom_info"));
		registration.addIngredientInfo(List.of(new ItemStack(CavesdelightModItems.STUFFED_AXOLOTL.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.cavesdelight.stuffed_axolotl_info"));
		registration.addIngredientInfo(List.of(new ItemStack(CavesdelightModItems.SPIDER_SILK.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.cavesdelight.spider_silk_info"));
	}
}