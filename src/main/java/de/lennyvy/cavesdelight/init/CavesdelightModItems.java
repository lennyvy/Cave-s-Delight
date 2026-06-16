/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package de.lennyvy.cavesdelight.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import de.lennyvy.cavesdelight.item.*;
import de.lennyvy.cavesdelight.CavesdelightMod;

public class CavesdelightModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(CavesdelightMod.MODID);
	public static final DeferredItem<Item> CHESS_FLOWER;
	public static final DeferredItem<Item> CHESS_FLOWER_SOUP;
	public static final DeferredItem<Item> RAW_GLOW_LICHEN;
	public static final DeferredItem<Item> COOKED_GLOW_LICHEN;
	public static final DeferredItem<Item> RAW_AXOLOTL_HAM;
	public static final DeferredItem<Item> COOKED_AXOLOTL_HAM;
	public static final DeferredItem<Item> SALT;
	public static final DeferredItem<Item> AMETHYST_POWDER;
	public static final DeferredItem<Item> CHESS_FLOWER_PETALS;
	public static final DeferredItem<Item> RAW_AXOLOTL_SLICE;
	public static final DeferredItem<Item> COOKED_AXOLOTL_SLICE;
	public static final DeferredItem<Item> SHIMMERING_MUSHROOM;
	public static final DeferredItem<Item> SMALL_SHIMMERING_MUSHROOMS;
	static {
		CHESS_FLOWER = block(CavesdelightModBlocks.CHESS_FLOWER);
		CHESS_FLOWER_SOUP = REGISTRY.register("chess_flower_soup", ChessFlowerSoupItem::new);
		RAW_GLOW_LICHEN = REGISTRY.register("raw_glow_lichen", RawGlowLichenItem::new);
		COOKED_GLOW_LICHEN = REGISTRY.register("cooked_glow_lichen", CookedGlowLichenItem::new);
		RAW_AXOLOTL_HAM = REGISTRY.register("raw_axolotl_ham", RawAxolotlHamItem::new);
		COOKED_AXOLOTL_HAM = REGISTRY.register("cooked_axolotl_ham", CookedAxolotlHamItem::new);
		SALT = REGISTRY.register("salt", SaltItem::new);
		AMETHYST_POWDER = REGISTRY.register("amethyst_powder", AmethystPowderItem::new);
		CHESS_FLOWER_PETALS = REGISTRY.register("chess_flower_petals", ChessFlowerPetalsItem::new);
		RAW_AXOLOTL_SLICE = REGISTRY.register("raw_axolotl_slice", RawAxolotlSliceItem::new);
		COOKED_AXOLOTL_SLICE = REGISTRY.register("cooked_axolotl_slice", CookedAxolotlSliceItem::new);
		SHIMMERING_MUSHROOM = block(CavesdelightModBlocks.SHIMMERING_MUSHROOM);
		SMALL_SHIMMERING_MUSHROOMS = block(CavesdelightModBlocks.SMALL_SHIMMERING_MUSHROOMS);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}