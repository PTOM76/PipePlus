package ml.pkom.pipeplus.blockentities;

import alexiil.mc.mod.pipes.blocks.PipeFlowItem;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import ml.pkom.pipeplus.blocks.Blocks;
import ml.pkom.pipeplus.blocks.RedStonePipe;
import net.minecraft.block.BlockState;

public class RedStonePipeEntity extends TilePipe {

    public RedStonePipeEntity() {
        super(BlockEntities.REDSTONE_PIPE_ENTITY, Blocks.REDSTONE_PIPE, PipeFlowItem::new);
    }

    @Override
    public void tick() {
        super.tick();
        if (!world.isClient) {
            RedStonePipe block = ((RedStonePipe) this.pipeBlock);
            BlockState state = getWorld().getBlockState(getPos());
            if (((PipeFlowItem) this.flow).getAllItemsForRender().isEmpty()) {
                block.setRedStoneSignal(state, getWorld(), getPos(), false);
            } else {
                block.setRedStoneSignal(state, getWorld(), getPos(), true);
            }
            block.updatePoweredStatus(getWorld(), getPos(), state);
        }
    }
}
