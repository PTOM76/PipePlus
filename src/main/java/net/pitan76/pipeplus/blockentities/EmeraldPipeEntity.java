package net.pitan76.pipeplus.blockentities;

import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;
import net.pitan76.pipeplus.blocks.Blocks;
import net.pitan76.pipeplus.pipeflow.EmeraldPipeFlow;

public class EmeraldPipeEntity extends ExtendTilePipe {

    public EmeraldPipeEntity(TileCreateEvent event) {
        super(BlockEntities.EMERALD_PIPE_ENTITY, event, Blocks.EMERALD_PIPE, EmeraldPipeFlow::new);
    }
}
