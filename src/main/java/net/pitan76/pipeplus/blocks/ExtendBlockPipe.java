package net.pitan76.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipe;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.pitan76.mcpitanlib.api.block.CompatibleBlockSettings;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;

public abstract class ExtendBlockPipe extends BlockPipe {
    @Deprecated
    public ExtendBlockPipe(Settings settings) {
        super(settings);
    }

    public ExtendBlockPipe(CompatibleBlockSettings settings) {
        super(settings.build());
    }

    @Deprecated
    public TilePipe createBlockEntity(BlockPos pos, BlockState state) {
        return createBlockEntity(new TileCreateEvent(pos, state));
    }

    @Deprecated
    @Override
    public TilePipe createBlockEntity(BlockView var1) {
        return createBlockEntity(new TileCreateEvent(var1));
    }

    public TilePipe createBlockEntity(TileCreateEvent event) {
        return null;
    }
}
