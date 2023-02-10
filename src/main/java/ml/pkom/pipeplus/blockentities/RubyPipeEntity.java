package ml.pkom.pipeplus.blockentities;

import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import ml.pkom.pipeplus.blocks.Blocks;
import ml.pkom.pipeplus.pipeflow.RubyPipeFlow;

public class RubyPipeEntity extends ExtendTilePipe {

    public RubyPipeEntity(TileCreateEvent event) {
        super(BlockEntities.RUBY_PIPE_ENTITY, event, Blocks.RUBY_PIPE, RubyPipeFlow::new);
    }
}
