package ml.pkom.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeSided;
import alexiil.mc.mod.pipes.blocks.TilePipeSided;
import alexiil.mc.mod.pipes.pipe.PipeSpDef;
import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public abstract class ExtendBlockPipeSided  extends BlockPipeSided {
    public ExtendBlockPipeSided(Settings settings, PipeSpDef pipeDef) {
        super(settings, pipeDef);
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
