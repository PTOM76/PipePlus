package ml.pkom.pipeplus.blockentities;

import alexiil.mc.mod.pipes.blocks.*;
import alexiil.mc.mod.pipes.pipe.PipeSpFlowItem;
import ml.pkom.pipeplus.blocks.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class CobbleStonePipeEntity extends TilePipe {

    public CobbleStonePipeEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.COBBLESTONE_PIPE_ENTITY, pos, state, Blocks.COBBLESTONE_PIPE, PipeSpFlowItem::new);
    }

    @Override
    protected void onNeighbourChange() {
        Direction[] var1 = Direction.values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Direction dir = var1[var3];
            BlockEntity oTile = this.world.getBlockEntity(this.getPos().offset(dir));
            if (oTile instanceof TilePipeItemStone) {
                this.disconnect(dir);
                ((TilePipeItemStone) oTile).disconnect(dir.getOpposite());
            } else if (oTile instanceof TilePipe) {
                if (this.getFlow() instanceof PipeSpFlowItem == (((TilePipe)oTile).getFlow() instanceof PipeSpFlowItem)) {
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
