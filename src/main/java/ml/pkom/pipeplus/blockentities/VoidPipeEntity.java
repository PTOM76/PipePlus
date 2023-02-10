package ml.pkom.pipeplus.blockentities;

import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import ml.pkom.pipeplus.blocks.Blocks;
import ml.pkom.pipeplus.pipeflow.VoidPipeFlowItem;

public class VoidPipeEntity extends ExtendTilePipe {
    public VoidPipeEntity(TileCreateEvent event) {
        super(BlockEntities.VOID_ITEM_PIPE_TILE_ENTITY, event, Blocks.VOID_ITEM_PIPE, VoidPipeFlowItem::new);
    }
}
