/*
*    MCreator note: This file will be REGENERATED on each build.
*/
package de.lennyvy.cavesdelight.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.Registries;

import java.util.function.Supplier;

import de.lennyvy.cavesdelight.block.*;
import de.lennyvy.cavesdelight.CavesdelightMod;

public class CavesdelightModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(CavesdelightMod.MODID);
	public static final DeferredBlock<Block> CHESS_FLOWER;
	public static final DeferredBlock<Block> SHIMMERING_MUSHROOM;
	public static final DeferredBlock<Block> SMALL_SHIMMERING_MUSHROOMS;
	public static final DeferredBlock<Block> DEEP_COAL_ORE;
	public static final DeferredBlock<Block> HYACINTH_FLOWER;
	public static final DeferredBlock<Block> WILD_LEEK_PLANT;
	static {
		CHESS_FLOWER = REGISTRY.register("chess_flower", ChessFlowerBlock::new);
		SHIMMERING_MUSHROOM = REGISTRY.register("shimmering_mushroom", ShimmeringMushroomBlock::new);
		SMALL_SHIMMERING_MUSHROOMS = REGISTRY.register("small_shimmering_mushrooms", SmallShimmeringMushroomsBlock::new);
		DEEP_COAL_ORE = REGISTRY.register("deep_coal_ore", DeepCoalOreBlock::new);
		HYACINTH_FLOWER = REGISTRY.register("hyacinth_flower", HyacinthFlowerBlock::new);
		WILD_LEEK_PLANT = REGISTRY.register("wild_leek_plant", WildLeekPlantBlock::new);
	}
	// Start of user code block custom blocks
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, CavesdelightMod.MODID);
	public static final DeferredBlock<Block> RAW_STUFFED_AXOLOTL = REGISTRY.register("raw_stuffed_axolotl",
			() -> new RawStuffedAxolotlBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).strength(0.5f).sound(SoundType.WOOL).noOcclusion()));
	public static final DeferredBlock<Block> COOKED_STUFFED_AXOLOTL = REGISTRY.register("cooked_stuffed_axolotl",
			() -> new CookedStuffedAxolotlBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).strength(0.5f).sound(SoundType.WOOL).noOcclusion()));
	public static final DeferredBlock<Block> COOKED_STUFFED_AXOLOTL_STAGE0 = REGISTRY.register("cooked_stuffed_axolotl_stage0",
			() -> new CookedStuffedAxolotlStage0Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).strength(0.5f).sound(SoundType.WOOL).noOcclusion()));
	public static final DeferredBlock<Block> COOKED_STUFFED_AXOLOTL_STAGE1 = REGISTRY.register("cooked_stuffed_axolotl_stage1",
			() -> new CookedStuffedAxolotlStage1Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).strength(0.5f).sound(SoundType.WOOL).noOcclusion()));
	public static final DeferredBlock<Block> COOKED_STUFFED_AXOLOTL_STAGE2 = REGISTRY.register("cooked_stuffed_axolotl_stage2",
			() -> new CookedStuffedAxolotlStage2Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).strength(0.5f).sound(SoundType.WOOL).noOcclusion()));
	public static final DeferredBlock<Block> COOKED_STUFFED_AXOLOTL_STAGE3 = REGISTRY.register("cooked_stuffed_axolotl_stage3",
			() -> new CookedStuffedAxolotlStage3Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).strength(0.5f).sound(SoundType.WOOL).noOcclusion()));
	public static final Supplier<Block> LEEK_CROP = BLOCKS.register("leek_crop", () -> new LeekCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion().noCollission()));
	// End of user code block custom blocks
}