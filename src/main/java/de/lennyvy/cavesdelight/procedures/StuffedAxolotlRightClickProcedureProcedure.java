package de.lennyvy.cavesdelight.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.component.CustomModelData;

import javax.annotation.Nullable;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Map;

import de.lennyvy.cavesdelight.init.CavesdelightModItems;
import de.lennyvy.cavesdelight.init.CavesdelightModBlocks;

@EventBusSubscriber
public class StuffedAxolotlRightClickProcedureProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getLevel().getBlockState(event.getPos()), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		execute(null, world, x, y, z, blockstate, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null) return;
		
		ItemStack mainHand = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		if (mainHand.getItem() != Items.BOWL) return;
		
		BlockPos pos = BlockPos.containing(x, y, z);
		BlockState currentState = blockstate;
		
		List<Map.Entry<BlockState, BlockState>> transitions = List.of(
			new SimpleEntry<>(CavesdelightModBlocks.COOKED_STUFFED_AXOLOTL.get().defaultBlockState(),
			                  CavesdelightModBlocks.COOKED_STUFFED_AXOLOTL_STAGE0.get().defaultBlockState()),
			new SimpleEntry<>(CavesdelightModBlocks.COOKED_STUFFED_AXOLOTL_STAGE0.get().defaultBlockState(),
			                  CavesdelightModBlocks.COOKED_STUFFED_AXOLOTL_STAGE1.get().defaultBlockState()),
			new SimpleEntry<>(CavesdelightModBlocks.COOKED_STUFFED_AXOLOTL_STAGE1.get().defaultBlockState(),
			                  CavesdelightModBlocks.COOKED_STUFFED_AXOLOTL_STAGE2.get().defaultBlockState()),
			new SimpleEntry<>(CavesdelightModBlocks.COOKED_STUFFED_AXOLOTL_STAGE2.get().defaultBlockState(),
			                  CavesdelightModBlocks.COOKED_STUFFED_AXOLOTL_STAGE3.get().defaultBlockState())
		);
		
		for (Map.Entry<BlockState, BlockState> transition : transitions) {
			BlockState from = transition.getKey();
			BlockState to = transition.getValue();
			if (currentState.getBlock() == from.getBlock()) {
				replaceBlockAndPlaySound(world, pos, to);
				mainHand.shrink(1);
				if (entity instanceof Player _player) {
					ItemStack burger = new ItemStack(CavesdelightModItems.STUFFED_AXOLOTL.get()).copy();
					burger.setCount(1);
					int color = 0;
					Property<?> colorProp = currentState.getBlock().getStateDefinition().getProperty("color");
					if (colorProp instanceof IntegerProperty intProp) {
						color = currentState.getValue(intProp);
					}
					burger.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(color));
					
					ItemHandlerHelper.giveItemToPlayer(_player, burger);
				}
				return;
			}
		}
		
		BlockState stage4Block = CavesdelightModBlocks.COOKED_STUFFED_AXOLOTL_STAGE3.get().defaultBlockState();
		if (currentState.getBlock() == stage4Block.getBlock()) {
			world.destroyBlock(pos, false);
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.BOWL));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
			playWoolBreakSound(world, x, y, z);
		}
	}
	
	private static void replaceBlockAndPlaySound(LevelAccessor world, BlockPos pos, BlockState newState) {
		BlockState oldState = world.getBlockState(pos);
		BlockState finalState = newState;
		for (Property<?> property : oldState.getProperties()) {
			Property newProperty = newState.getBlock().getStateDefinition().getProperty(property.getName());
			if (newProperty != null) {
				try {
					finalState = finalState.setValue(newProperty, oldState.getValue(property));
				} catch (Exception ignored) {}
			}
		}
		BlockEntity be = world.getBlockEntity(pos);
		CompoundTag nbt = null;
		if (be != null) {
			nbt = be.saveWithFullMetadata(world.registryAccess());
			be.setRemoved();
		}
		world.setBlock(pos, finalState, 3);
		if (nbt != null) {
			BlockEntity newBe = world.getBlockEntity(pos);
			if (newBe != null) {
				try {
					newBe.loadWithComponents(nbt, world.registryAccess());
				} catch (Exception ignored) {}
			}
		}
		playWoolBreakSound(world, pos.getX(), pos.getY(), pos.getZ());
	}
	
	private static void playWoolBreakSound(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level level) {
			level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.WOOL_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
		}
	}
}