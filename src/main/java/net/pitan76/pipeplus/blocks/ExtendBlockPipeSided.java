package net.pitan76.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeSided;
import alexiil.mc.mod.pipes.blocks.TilePipeSided;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.pitan76.mcpitanlib.api.block.CompatibleBlockSettings;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;

public abstract class ExtendBlockPipeSided  extends BlockPipeSided {
    @Deprecated
    public ExtendBlockPipeSided(Settings settings) {
        super(settings);
    }

    public ExtendBlockPipeSided(CompatibleBlockSettings settings) {
        super(settings.build());
    }

    @Deprecated
    public TilePipeSided createBlockEntity(BlockPos pos, BlockState state) {
        return createBlockEntity(new TileCreateEvent(pos, state));
    }

    @Override
    public TilePipeSided createBlockEntity(BlockView view) {
        return createBlockEntity(new TileCreateEvent(view));
    }

    public TilePipeSided createBlockEntity(TileCreateEvent event) {
        return null;
    }
}
