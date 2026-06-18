package de.lennyvy.cavesdelight.item;

import de.lennyvy.cavesdelight.block.RawStuffedAxolotlBlock;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomModelData;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class RawStuffedAxolotlItem extends BlockItem {

    public RawStuffedAxolotlItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean placeBlock(BlockPlaceContext context, BlockState state) {
        ItemStack stack = context.getItemInHand();
        CustomModelData cmd = stack.get(DataComponents.CUSTOM_MODEL_DATA);
        int color = 0;
        if (cmd != null) {
            color = Math.clamp(cmd.value(), 0, 4);
        }
        state = state.setValue(RawStuffedAxolotlBlock.COLOR, color)
                     .setValue(RawStuffedAxolotlBlock.FACING, context.getHorizontalDirection().getOpposite());
        return context.getLevel().setBlock(context.getClickedPos(), state, 3);
    }
}