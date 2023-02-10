package ml.pkom.pipeplus.blockentities;

import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import ml.pkom.pipeplus.blocks.Blocks;
import ml.pkom.pipeplus.pipeflow.EmeraldPipeFlow;

public class EmeraldPipeEntity extends ExtendTilePipe {

    public EmeraldPipeEntity(TileCreateEvent event) {
        super(BlockEntities.EMERALD_PIPE_ENTITY, event, Blocks.EMERALD_PIPE, EmeraldPipeFlow::new);
    }
}
