package net.pitan76.pipeplus.pipe;

import alexiil.mc.mod.pipes.part.SimplePipeParts;
import alexiil.mc.mod.pipes.pipe.PartSpPipe;
import alexiil.mc.mod.pipes.pipe.PipeSpBehaviour;
import net.minecraft.util.math.Direction;

public class PipeSpBehaviourCobblestone extends PipeSpBehaviour {
    public PipeSpBehaviourCobblestone(PartSpPipe pipe) {
        super(pipe);
    }

    @Override
    public boolean canConnect(Direction dir) {
        if (pipe.getNeighbourPipe(dir) != null && pipe.getNeighbourPipe(dir).getDefinition() != null &&
                pipe.getNeighbourPipe(dir).getDefinition() == SimplePipeParts.STONE_PIPE_ITEMS) return false;
        return super.canConnect(dir);
    }
}
