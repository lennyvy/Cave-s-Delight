/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package de.lennyvy.cavesdelight.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import de.lennyvy.cavesdelight.CavesdelightMod;

public class CavesdelightModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CavesdelightMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CAVES_DELIGHT = REGISTRY.register("caves_delight",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.cavesdelight.caves_delight")).icon(() -> new ItemStack(CavesdelightModBlocks.CHESS_FLOWER.get())).displayItems((parameters, tabData) -> {
				tabData.accept(CavesdelightModBlocks.CHESS_FLOWER.get().asItem());
				tabData.accept(CavesdelightModItems.CHESS_FLOWER_PETALS.get());
				tabData.accept(CavesdelightModBlocks.HYACINTH_FLOWER.get().asItem());
				tabData.accept(CavesdelightModItems.HYACINTH_FLOWER_PETALS.get());
				tabData.accept(CavesdelightModItems.RAW_GLOW_LICHEN.get());
				tabData.accept(CavesdelightModItems.COOKED_GLOW_LICHEN.get());
				tabData.accept(CavesdelightModItems.RAW_AXOLOTL_HAM.get());
				tabData.accept(CavesdelightModItems.RAW_AXOLOTL_SLICE.get());
				tabData.accept(CavesdelightModItems.COOKED_AXOLOTL_SLICE.get());
				tabData.accept(CavesdelightModItems.SALT.get());
				tabData.accept(CavesdelightModItems.AMETHYST_POWDER.get());
				tabData.accept(CavesdelightModItems.AXOLOTL_SPICES.get());
				tabData.accept(CavesdelightModBlocks.SHIMMERING_MUSHROOM.get().asItem());
				tabData.accept(CavesdelightModBlocks.SMALL_SHIMMERING_MUSHROOMS.get().asItem());
				tabData.accept(CavesdelightModItems.SHIMMERING_MUSHROOM_SLICE.get());
				tabData.accept(CavesdelightModItems.SMALL_SHIMMERING_MUSHROOM_SLICE.get());
				tabData.accept(CavesdelightModBlocks.DEEP_COAL_ORE.get().asItem());
				tabData.accept(CavesdelightModItems.DEEP_COAL.get());
				tabData.accept(CavesdelightModItems.DEEP_COAL_CRUMBS.get());
				tabData.accept(CavesdelightModItems.DEEP_COAL_CEREALS.get());
				tabData.accept(CavesdelightModItems.GLOW_LICHEN_WITH_DEEP_COAL.get());
				tabData.accept(CavesdelightModItems.INFUSED_MUSHROOM_WRAP.get());
				tabData.accept(CavesdelightModItems.COOKED_AXOLOTL_HAM.get());
				tabData.accept(CavesdelightModItems.CHESS_FLOWER_SOUP.get());
			}).build());
}