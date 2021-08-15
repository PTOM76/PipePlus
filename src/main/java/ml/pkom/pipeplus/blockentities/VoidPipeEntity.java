package ml.pkom.pipeplus.blockentities;

import alexiil.mc.mod.pipes.blocks.TilePipe;
import ml.pkom.pipeplus.blocks.Blocks;
import ml.pkom.pipeplus.pipeflow.VoidPipeFlowItem;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class VoidPipeEntity extends TilePipe {

    public VoidPipeEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.VOID_ITEM_PIPE_TILE_ENTITY, pos, state, Blocks.VOID_ITEM_PIPE, VoidPipeFlowItem::new);
    }
}
