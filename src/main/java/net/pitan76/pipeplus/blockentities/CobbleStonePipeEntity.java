package net.pitan76.pipeplus.blockentities;

import alexiil.mc.mod.pipes.blocks.PipeFlowItem;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import alexiil.mc.mod.pipes.blocks.TilePipeItemStone;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.Direction;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;
import net.pitan76.pipeplus.blocks.Blocks;

public class CobbleStonePipeEntity extends ExtendTilePipe {

    public CobbleStonePipeEntity(TileCreateEvent event) {
        super(BlockEntities.COBBLESTONE_PIPE_ENTITY, event, Blocks.COBBLESTONE_PIPE, PipeFlowItem::new);
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
                if (this.flow instanceof PipeFlowItem == (((TilePipe) oTile).flow instanceof PipeFlowItem)) {
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
