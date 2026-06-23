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

public class CookedStuffedAxolotlStage3Block extends HorizontalDirectionalBlock {

    public static final IntegerProperty COLOR = IntegerProperty.create("color", 0, 4);
    public static final MapCodec<CookedStuffedAxolotlStage3Block> CODEC = simpleCodec(CookedStuffedAxolotlStage3Block::new);

    private static final VoxelShape TRAY = Block.box(1, 0, 1, 15, 2, 15);

    private static final VoxelShape SHAPE_NORTH = Shapes.or(TRAY);
    private static final VoxelShape SHAPE_EAST = Shapes.or(TRAY);
    private static final VoxelShape SHAPE_SOUTH = Shapes.or(TRAY);
    private static final VoxelShape SHAPE_WEST = Shapes.or(TRAY);

    public CookedStuffedAxolotlStage3Block(Properties properties) {
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