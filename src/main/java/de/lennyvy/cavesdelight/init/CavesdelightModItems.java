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
	public static final DeferredItem<Item> DEEP_COAL;
	public static final DeferredItem<Item> DEEP_COAL_ORE;
	public static final DeferredItem<Item> DEEP_COAL_CRUMBS;
	public static final DeferredItem<Item> GLOW_LICHEN_WITH_DEEP_COAL;
	public static final DeferredItem<Item> SHIMMERING_MUSHROOM_SLICE;
	public static final DeferredItem<Item> SMALL_SHIMMERING_MUSHROOM_SLICE;
	public static final DeferredItem<Item> HYACINTH_FLOWER;
	public static final DeferredItem<Item> HYACINTH_FLOWER_PETALS;
	public static final DeferredItem<Item> INFUSED_MUSHROOM_WRAP;
	public static final DeferredItem<Item> DEEP_COAL_CEREALS;
	public static final DeferredItem<Item> AXOLOTL_WRAP;
	public static final DeferredItem<Item> AXOLOTL_HIDE;
	public static final DeferredItem<Item> AXOLOTL_ROLL;
	public static final DeferredItem<Item> HYACINTH_FLOWER_SOUP;
	public static final DeferredItem<Item> GLOW_BERRY_SAUCE;
	public static final DeferredItem<Item> BURGER_BUNS;
	public static final DeferredItem<Item> AXOLOTL_BURGER;
	public static final DeferredItem<Item> DOUBLE_AXOLOTL_BURGER;
	public static final DeferredItem<Item> INFUSED_MUSHROOM_BURGER;
	public static final DeferredItem<Item> INFUSED_DOUBLE_MUSHROOM_BURGER;
	public static final DeferredItem<Item> GLAZED_AXOLOTL_HAM;
	public static final DeferredItem<Item> SPIDER_LEG;
	public static final DeferredItem<Item> SHIMMERING_GLOW_LICHEN;
	public static final DeferredItem<Item> SLIME_JELLO_GREEN;
	public static final DeferredItem<Item> SLIME_JELLO_BLACK;
	public static final DeferredItem<Item> SLIME_JELLO_BLUE;
	public static final DeferredItem<Item> SLIME_JELLO_BROWN;
	public static final DeferredItem<Item> SLIME_JELLO_ORANGE;
	public static final DeferredItem<Item> SLIME_JELLO_PINK;
	public static final DeferredItem<Item> SLIME_JELLO_PURPLE;
	public static final DeferredItem<Item> SLIME_JELLO_RED;
	public static final DeferredItem<Item> SLIME_JELLO_YELLOW;
	public static final DeferredItem<Item> SLIME_JELLO_WHITE;
	public static final DeferredItem<Item> SLIME_JELLO_BASE;
	public static final DeferredItem<Item> BURGER_BUN;
	public static final DeferredItem<Item> SPIDER_BURGER;
	public static final DeferredItem<Item> DOUBLE_SPIDER_BURGER;
	public static final DeferredItem<Item> STUFFED_AXOLOTL;
	public static final DeferredItem<Item> COTTON_CANDY;
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
		DEEP_COAL = REGISTRY.register("deep_coal", DeepCoalItem::new);
		DEEP_COAL_ORE = block(CavesdelightModBlocks.DEEP_COAL_ORE, new Item.Properties().fireResistant());
		DEEP_COAL_CRUMBS = REGISTRY.register("deep_coal_crumbs", DeepCoalCrumbsItem::new);
		GLOW_LICHEN_WITH_DEEP_COAL = REGISTRY.register("glow_lichen_with_deep_coal", GlowLichenWithDeepCoalItem::new);
		SHIMMERING_MUSHROOM_SLICE = REGISTRY.register("shimmering_mushroom_slice", ShimmeringMushroomSliceItem::new);
		SMALL_SHIMMERING_MUSHROOM_SLICE = REGISTRY.register("small_shimmering_mushroom_slice", SmallShimmeringMushroomSliceItem::new);
		HYACINTH_FLOWER = block(CavesdelightModBlocks.HYACINTH_FLOWER);
		HYACINTH_FLOWER_PETALS = REGISTRY.register("hyacinth_flower_petals", HyacinthFlowerPetalsItem::new);
		INFUSED_MUSHROOM_WRAP = REGISTRY.register("infused_mushroom_wrap", InfusedMushroomWrapItem::new);
		DEEP_COAL_CEREALS = REGISTRY.register("deep_coal_cereals", DeepCoalCerealsItem::new);
		AXOLOTL_WRAP = REGISTRY.register("axolotl_wrap", AxolotlWrapItem::new);
		AXOLOTL_HIDE = REGISTRY.register("axolotl_hide", AxolotlHideItem::new);
		AXOLOTL_ROLL = REGISTRY.register("axolotl_roll", AxolotlRollItem::new);
		HYACINTH_FLOWER_SOUP = REGISTRY.register("hyacinth_flower_soup", HyacinthFlowerSoupItem::new);
		GLOW_BERRY_SAUCE = REGISTRY.register("glow_berry_sauce", GlowBerrySauceItem::new);
		BURGER_BUNS = REGISTRY.register("burger_buns", BurgerBunsItem::new);
		AXOLOTL_BURGER = REGISTRY.register("axolotl_burger", AxolotlBurgerItem::new);
		DOUBLE_AXOLOTL_BURGER = REGISTRY.register("double_axolotl_burger", DoubleAxolotlBurgerItem::new);
		INFUSED_MUSHROOM_BURGER = REGISTRY.register("infused_mushroom_burger", InfusedMushroomBurgerItem::new);
		INFUSED_DOUBLE_MUSHROOM_BURGER = REGISTRY.register("infused_double_mushroom_burger", InfusedDoubleMushroomBurgerItem::new);
		GLAZED_AXOLOTL_HAM = REGISTRY.register("glazed_axolotl_ham", GlazedAxolotlHamItem::new);
		SPIDER_LEG = REGISTRY.register("spider_leg", SpiderLegItem::new);
		SHIMMERING_GLOW_LICHEN = REGISTRY.register("shimmering_glow_lichen", ShimmeringGlowLichenItem::new);
		SLIME_JELLO_GREEN = REGISTRY.register("slime_jello_green", SlimeJelloGreenItem::new);
		SLIME_JELLO_BLACK = REGISTRY.register("slime_jello_black", SlimeJelloBlackItem::new);
		SLIME_JELLO_BLUE = REGISTRY.register("slime_jello_blue", SlimeJelloBlueItem::new);
		SLIME_JELLO_BROWN = REGISTRY.register("slime_jello_brown", SlimeJelloBrownItem::new);
		SLIME_JELLO_ORANGE = REGISTRY.register("slime_jello_orange", SlimeJelloOrangeItem::new);
		SLIME_JELLO_PINK = REGISTRY.register("slime_jello_pink", SlimeJelloPinkItem::new);
		SLIME_JELLO_PURPLE = REGISTRY.register("slime_jello_purple", SlimeJelloPurpleItem::new);
		SLIME_JELLO_RED = REGISTRY.register("slime_jello_red", SlimeJelloRedItem::new);
		SLIME_JELLO_YELLOW = REGISTRY.register("slime_jello_yellow", SlimeJelloYellowItem::new);
		SLIME_JELLO_WHITE = REGISTRY.register("slime_jello_white", SlimeJelloWhiteItem::new);
		SLIME_JELLO_BASE = REGISTRY.register("slime_jello_base", SlimeJelloBaseItem::new);
		BURGER_BUN = REGISTRY.register("burger_bun", BurgerBunItem::new);
		SPIDER_BURGER = REGISTRY.register("spider_burger", SpiderBurgerItem::new);
		DOUBLE_SPIDER_BURGER = REGISTRY.register("double_spider_burger", DoubleSpiderBurgerItem::new);
		STUFFED_AXOLOTL = REGISTRY.register("stuffed_axolotl", StuffedAxolotlItem::new);
		COTTON_CANDY = REGISTRY.register("cotton_candy", CottonCandyItem::new);
	}
	// Start of user code block custom items
	public static final DeferredItem<Item> RAW_STUFFED_AXOLOTL = REGISTRY.register("raw_stuffed_axolotl", () -> new RawStuffedAxolotlItem(CavesdelightModBlocks.RAW_STUFFED_AXOLOTL.get(), new Item.Properties()));
	public static final DeferredItem<Item> COOKED_STUFFED_AXOLOTL = REGISTRY.register("cooked_stuffed_axolotl", () -> new CookedStuffedAxolotlItem(CavesdelightModBlocks.COOKED_STUFFED_AXOLOTL.get(), new Item.Properties()));

	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}