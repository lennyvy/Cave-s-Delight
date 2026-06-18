package de.lennyvy.cavesdelight.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomModelData;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import com.mojang.serialization.MapCodec;

import java.util.List;

public class RawStuffedAxolotlBlock extends HorizontalDirectionalBlock {

    public static final IntegerProperty COLOR = IntegerProperty.create("color", 0, 4);
    public static final MapCodec<RawStuffedAxolotlBlock> CODEC = simpleCodec(RawStuffedAxolotlBlock::new);

    // Tray (fix, da quadratisch)
    private static final VoxelShape TRAY = Block.box(1, 0, 1, 15, 2, 15);

    // Körper + Kopf für Norden (Standard)
    private static final VoxelShape BODY_NORTH = Shapes.or(
        Block.box(4, 1, 4, 12, 5, 14),    // Körper
        Block.box(4, 1.5, 1, 12, 5.5, 6)  // Kopf
    );

    // Körper + Kopf für Osten
    private static final VoxelShape BODY_EAST = Shapes.or(
        Block.box(2, 1, 4, 12, 5, 12),
        Block.box(10, 1.5, 4, 15, 5.5, 12)
    );

    // Körper + Kopf für Süden
    private static final VoxelShape BODY_SOUTH = Shapes.or(
        Block.box(4, 1, 2, 12, 5, 12),
        Block.box(4, 1.5, 10, 12, 5.5, 15)
    );

    // Körper + Kopf für Westen
    private static final VoxelShape BODY_WEST = Shapes.or(
        Block.box(4, 1, 4, 14, 5, 12),
        Block.box(1, 1.5, 4, 6, 5.5, 12)
    );

    // Kombinierte Shapes (Tray + rotierter Körper)
    private static final VoxelShape SHAPE_NORTH = Shapes.or(TRAY, BODY_NORTH);
    private static final VoxelShape SHAPE_EAST = Shapes.or(TRAY, BODY_EAST);
    private static final VoxelShape SHAPE_SOUTH = Shapes.or(TRAY, BODY_SOUTH);
    private static final VoxelShape SHAPE_WEST = Shapes.or(TRAY, BODY_WEST);

    public RawStuffedAxolotlBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
            .setValue(FACING, Direction.NORTH)
            .setValue(COLOR, 0));
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, COLOR);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
            .setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case EAST -> SHAPE_EAST;
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            default -> SHAPE_NORTH;
        };
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
        ItemStack stack = super.getCloneItemStack(level, pos, state);
        int color = state.getValue(COLOR);
        if (color > 0) {
            stack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(color));
        }
        return stack;
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
        List<ItemStack> drops = super.getDrops(state, builder);
        int color = state.getValue(COLOR);
        if (color > 0) {
            for (ItemStack drop : drops) {
                if (drop.getItem() == this.asItem()) {
                    drop.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(color));
                }
            }
        }
        return drops;
    }
}