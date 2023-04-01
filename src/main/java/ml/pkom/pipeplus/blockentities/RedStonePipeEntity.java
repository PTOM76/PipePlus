package ml.pkom.pipeplus.blockentities;

import alexiil.mc.mod.pipes.pipe.PipeSpFlowItem;
import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import ml.pkom.pipeplus.blocks.Blocks;
import ml.pkom.pipeplus.blocks.RedstonePipe;
import net.minecraft.block.BlockState;

public class RedStonePipeEntity extends ExtendTilePipe {

    public RedStonePipeEntity(TileCreateEvent event) {
        super(BlockEntities.REDSTONE_PIPE_ENTITY, event, Blocks.REDSTONE_PIPE, PipeSpFlowItem::new);
    }

    @Override
    public void tick() {
        super.tick();
        if (world == null) return;
        if (!world.isClient) {
            RedstonePipe block = ((RedstonePipe) this.pipeBlock);
            BlockState state = getWorld().getBlockState(getPos());
            block.setRedstoneSignal(state, getWorld(), getPos(), !((PipeSpFlowItem) this.getFlow()).getAllItemsForRender().isEmpty());
            block.updatePoweredStatus(getWorld(), getPos(), state);
        }
    }
}
