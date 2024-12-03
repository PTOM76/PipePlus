package net.pitan76.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeSided;
import alexiil.mc.mod.pipes.blocks.TilePipeSided;
import alexiil.mc.mod.pipes.pipe.PipeSpDef;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.pitan76.mcpitanlib.api.block.v2.CompatibleBlockSettings;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;

public abstract class CompatBlockPipeSided extends BlockPipeSided {
    @Deprecated
    public CompatBlockPipeSided(Settings settings, PipeSpDef pipeDef) {
        super(settings, pipeDef);
    }

    public CompatBlockPipeSided(CompatibleBlockSettings settings, PipeSpDef pipeDef) {
        this(settings.build(), pipeDef);
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
