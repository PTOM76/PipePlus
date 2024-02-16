package net.pitan76.pipeplus.blockentities;

import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;
import net.pitan76.pipeplus.blocks.Blocks;
import net.pitan76.pipeplus.pipeflow.RubyPipeFlow;

public class RubyPipeEntity extends ExtendTilePipe {

    public RubyPipeEntity(TileCreateEvent event) {
        super(BlockEntities.RUBY_PIPE_ENTITY, event, Blocks.RUBY_PIPE, RubyPipeFlow::new);
    }
}
