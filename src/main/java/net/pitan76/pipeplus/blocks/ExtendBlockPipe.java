package net.pitan76.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipe;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import alexiil.mc.mod.pipes.pipe.PipeSpDef;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public abstract class ExtendBlockPipe extends BlockPipe {
    public ExtendBlockPipe(Settings settings, PipeSpDef pipeDef) {
        super(settings, pipeDef);
    }

    @Deprecated
    @Override
    public TilePipe createBlockEntity(BlockPos pos, BlockState state) {
        return createBlockEntity(new TileCreateEvent(pos, state));
    }
    
    public TilePipe createBlockEntity(TileCreateEvent event) {
        return null;
    }
}
