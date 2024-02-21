package net.pitan76.pipeplus.superClass.blocks;

import alexiil.mc.mod.pipes.pipe.PipeSpDef;
import net.pitan76.mcpitanlib.api.block.CompatibleBlockSettings;
import net.pitan76.pipeplus.blocks.ExtendBlockPipe;

public abstract class BlockPipeTeleport extends ExtendBlockPipe {

    @Deprecated
    public BlockPipeTeleport(Settings settings, PipeSpDef pipeSpDef) {
        super(settings, pipeSpDef);
    }

    public BlockPipeTeleport(CompatibleBlockSettings settings, PipeSpDef pipeSpDef) {
        super(settings, pipeSpDef);
    }
}
