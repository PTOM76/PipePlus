package net.pitan76.pipeplus.blockentities;

import alexiil.mc.mod.pipes.pipe.PipeSpFlowItem;
import net.minecraft.block.BlockState;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;
import net.pitan76.pipeplus.blocks.Blocks;
import net.pitan76.pipeplus.blocks.RedStonePipe;

public class RedStonePipeEntity extends ExtendTilePipe {

    public RedStonePipeEntity(TileCreateEvent event) {
        super(BlockEntities.REDSTONE_PIPE_ENTITY, event, Blocks.REDSTONE_PIPE, PipeSpFlowItem::new);
    }

    @Override
    public void tick() {
        super.tick();
        if (world == null) return;
        if (!world.isClient) {
            RedStonePipe block = ((RedStonePipe) this.pipeBlock);
            BlockState state = getWorld().getBlockState(getPos());
            block.setRedStoneSignal(state, getWorld(), getPos(), !((PipeSpFlowItem) this.getFlow()).getAllItemsForRender().isEmpty());
            block.updatePoweredStatus(getWorld(), getPos(), state);
        }
    }
}
