package ml.pkom.pipeplus.blockentities;

import alexiil.mc.mod.pipes.blocks.TilePipe;
import ml.pkom.pipeplus.blocks.Blocks;
import ml.pkom.pipeplus.pipeflow.EmeraldPipeFlow;
import ml.pkom.pipeplus.pipeflow.RubyPipeFlow;

public class RubyPipeEntity extends TilePipe {

    public RubyPipeEntity() {
        super(BlockEntities.RUBY_PIPE_ENTITY, Blocks.RUBY_PIPE, RubyPipeFlow::new);
    }
}
