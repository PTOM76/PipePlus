package ml.pkom.pipeplus.blockentities;

import alexiil.mc.mod.pipes.blocks.TilePipe;
import ml.pkom.pipeplus.blocks.Blocks;
import ml.pkom.pipeplus.pipeflow.EmeraldPipeFlow;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class EmeraldPipeEntity extends TilePipe {

    public EmeraldPipeEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.EMERALD_PIPE_ENTITY, pos, state, Blocks.EMERALD_PIPE, EmeraldPipeFlow::new);
    }
}
