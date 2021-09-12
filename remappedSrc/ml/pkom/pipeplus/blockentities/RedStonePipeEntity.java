package ml.pkom.pipeplus.blockentities;

import alexiil.mc.mod.pipes.blocks.TilePipe;
import alexiil.mc.mod.pipes.pipe.PipeSpFlowItem;
import ml.pkom.pipeplus.blocks.Blocks;
import ml.pkom.pipeplus.blocks.RedStonePipe;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class RedStonePipeEntity extends TilePipe {

    public RedStonePipeEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.REDSTONE_PIPE_ENTITY, pos, state, Blocks.REDSTONE_PIPE, PipeSpFlowItem::new);
    }

    @Override
    public void tick() {
        super.tick();
        if (!world.isClient) {
            RedStonePipe block = ((RedStonePipe) this.pipeBlock);
            BlockState state = getWorld().getBlockState(getPos());
            if (((PipeSpFlowItem) this.getFlow()).getAllItemsForRender().isEmpty()) {
                block.setRedStoneSignal(state, getWorld(), getPos(), false);
            } else {
                block.setRedStoneSignal(state, getWorld(), getPos(), true);
            }
            block.updatePoweredStatus(getWorld(), getPos(), state);
        }
    }
}
