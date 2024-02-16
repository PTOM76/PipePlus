package net.pitan76.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeSided;
import alexiil.mc.mod.pipes.blocks.TilePipeSided;
import alexiil.mc.mod.pipes.pipe.PipeSpDef;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.pitan76.mcpitanlib.api.block.CompatibleBlockSettings;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;

public abstract class ExtendBlockPipeSided  extends BlockPipeSided {
    @Deprecated
    public ExtendBlockPipeSided(Settings settings, PipeSpDef pipeDef) {
        super(settings, pipeDef);
    }

    public ExtendBlockPipeSided(CompatibleBlockSettings settings, PipeSpDef pipeDef) {
        super(settings.build(), pipeDef);
    }

    @Deprecated
    @Override
    public TilePipeSided createBlockEntity(BlockPos pos, BlockState state) {
        return createBlockEntity(new TileCreateEvent(pos, state));
    }

    public TilePipeSided createBlockEntity(TileCreateEvent event) {
        return null;
    }
}
