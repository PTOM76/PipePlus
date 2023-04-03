package ml.pkom.pipeplus.blockentities;

import alexiil.mc.mod.pipes.pipe.PipeSpFlowItem;
import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import ml.pkom.pipeplus.blocks.Blocks;
import ml.pkom.pipeplus.blocks.PipeBlockModelStateMutable;
import ml.pkom.pipeplus.blocks.RedstonePipe;
import net.minecraft.block.BlockState;

public class RedStonePipeEntity extends ExtendTilePipe {

    public boolean isEmpty;

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

            isEmpty = ((PipeSpFlowItem) this.getFlow()).getAllItemsForRender().isEmpty();

            block.setRedstoneSignal(state, getWorld(), getPos(), !isEmpty);
            block.updatePoweredStatus(getWorld(), getPos(), state);
        }
    }

    @Override
    protected PipeBlockModelState createModelState() {
        return new PipeBlockModelStateMutable(pipeBlock.pipeDef, encodeConnectedSides(), isEmpty ? 0 : 1);
    }
}
