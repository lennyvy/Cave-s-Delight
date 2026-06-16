/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package de.lennyvy.cavesdelight.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import de.lennyvy.cavesdelight.block.SmallShimmeringMushroomsBlock;
import de.lennyvy.cavesdelight.block.ShimmeringMushroomBlock;
import de.lennyvy.cavesdelight.block.ChessFlowerBlock;
import de.lennyvy.cavesdelight.CavesdelightMod;

public class CavesdelightModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(CavesdelightMod.MODID);
	public static final DeferredBlock<Block> CHESS_FLOWER;
	public static final DeferredBlock<Block> SHIMMERING_MUSHROOM;
	public static final DeferredBlock<Block> SMALL_SHIMMERING_MUSHROOMS;
	static {
		CHESS_FLOWER = REGISTRY.register("chess_flower", ChessFlowerBlock::new);
		SHIMMERING_MUSHROOM = REGISTRY.register("shimmering_mushroom", ShimmeringMushroomBlock::new);
		SMALL_SHIMMERING_MUSHROOMS = REGISTRY.register("small_shimmering_mushrooms", SmallShimmeringMushroomsBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}