package net.pitan76.pipeplus.blockentities;

import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;
import net.pitan76.pipeplus.blocks.Blocks;
import net.pitan76.pipeplus.pipeflow.VoidPipeFlowItem;

public class VoidPipeEntity extends ExtendTilePipe {
    public VoidPipeEntity(TileCreateEvent event) {
        super(BlockEntities.VOID_ITEM_PIPE_TILE_ENTITY, event, Blocks.VOID_ITEM_PIPE, VoidPipeFlowItem::new);
    }
}
