package net.pitan76.pipeplus.blockentities;

import alexiil.mc.mod.pipes.blocks.BlockPipe;
import alexiil.mc.mod.pipes.blocks.PipeFlow;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;

import java.util.function.Function;

public class ExtendTilePipe extends TilePipe {

    public ExtendTilePipe(BlockEntityType<?> type, TileCreateEvent event, BlockPipe pipeBlock, Function<TilePipe, PipeFlow> flowConstructor) {
        this(type, event.getBlockPos(), event.getBlockState(), pipeBlock, flowConstructor);
    }

    @Deprecated
    public ExtendTilePipe(BlockEntityType<?> type, BlockPos pos, BlockState state, BlockPipe pipeBlock, Function<TilePipe, PipeFlow> flowConstructor) {
        super(type, pipeBlock, flowConstructor);
    }
}
