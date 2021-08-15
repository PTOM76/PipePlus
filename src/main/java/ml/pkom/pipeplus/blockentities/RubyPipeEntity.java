package ml.pkom.pipeplus.blockentities;

import alexiil.mc.mod.pipes.blocks.TilePipe;
import ml.pkom.pipeplus.blocks.Blocks;
import ml.pkom.pipeplus.pipeflow.RubyPipeFlow;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class RubyPipeEntity extends TilePipe {

    public RubyPipeEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.RUBY_PIPE_ENTITY, pos, state, Blocks.RUBY_PIPE, RubyPipeFlow::new);
    }
}
