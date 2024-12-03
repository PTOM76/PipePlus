package net.pitan76.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipe;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import alexiil.mc.mod.pipes.pipe.PipeSpDef;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.pitan76.mcpitanlib.api.block.v2.CompatibleBlockSettings;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;

public abstract class CompatBlockPipe extends BlockPipe {
    @Deprecated
    public CompatBlockPipe(Settings settings, PipeSpDef pipeDef) {
        super(settings, pipeDef);
    }

    public CompatBlockPipe(CompatibleBlockSettings settings, PipeSpDef pipeDef) {
        this(settings.build(), pipeDef);
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
