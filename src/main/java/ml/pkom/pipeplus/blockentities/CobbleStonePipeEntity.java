package ml.pkom.pipeplus.blockentities;

import alexiil.mc.mod.pipes.blocks.TilePipe;
import alexiil.mc.mod.pipes.blocks.TilePipeItemStone;
import alexiil.mc.mod.pipes.pipe.PipeSpFlowItem;
import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import ml.pkom.pipeplus.blocks.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.Direction;

public class CobbleStonePipeEntity extends ExtendTilePipe {

    public CobbleStonePipeEntity(TileCreateEvent event) {
        super(BlockEntities.COBBLESTONE_PIPE_ENTITY, event, Blocks.COBBLESTONE_PIPE, PipeSpFlowItem::new);
    }

    @Override
    protected void onNeighbourChange() {
        Direction[] var1 = Direction.values();
        int var2 = var1.length;

        for (Direction dir : var1) {
            BlockEntity oTile = this.world.getBlockEntity(this.getPos().offset(dir));
            if (oTile instanceof TilePipeItemStone) {
                this.disconnect(dir);
                ((TilePipeItemStone) oTile).disconnect(dir.getOpposite());
            } else if (oTile instanceof TilePipe) {
                if (this.getFlow() instanceof PipeSpFlowItem == (((TilePipe) oTile).getFlow() instanceof PipeSpFlowItem)) {
                    this.connect(dir);
                } else {
                    this.disconnect(dir);
                }
            } else if (this.canConnect(dir)) {
                this.connect(dir);
            } else {
                this.disconnect(dir);
            }
        }

    }
}
