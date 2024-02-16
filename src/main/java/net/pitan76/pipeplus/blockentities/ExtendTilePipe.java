package net.pitan76.pipeplus.blockentities;

import alexiil.mc.mod.pipes.blocks.BlockPipe;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import alexiil.mc.mod.pipes.pipe.PipeSpFlow;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

import java.util.function.Function;

public class ExtendTilePipe extends TilePipe {

    public ExtendTilePipe(BlockEntityType<?> type, TileCreateEvent event, BlockPipe pipeBlock, Function<TilePipe, PipeSpFlow> flowConstructor) {
        this(type, event.getBlockPos(), event.getBlockState(), pipeBlock, flowConstructor);
    }

    @Deprecated
    public ExtendTilePipe(BlockEntityType<?> type, BlockPos pos, BlockState state, BlockPipe pipeBlock, Function<TilePipe, PipeSpFlow> flowConstructor) {
        super(type, pos, state, pipeBlock, flowConstructor);
    }
}
