package net.pitan76.pipeplus.pipe;

import alexiil.mc.lib.attributes.fluid.impl.EmptyFluidExtractable;
import alexiil.mc.mod.pipes.pipe.PartSpPipe;
import alexiil.mc.mod.pipes.pipe.PipeSpFlowFluid;
import net.minecraft.util.math.Direction;

public class PipeSpBehaviourFluidExtract extends PipeSpBehaviourItemExtract {
    public PipeSpBehaviourFluidExtract(PartSpPipe pipe, int time) {
        super(pipe, time, 0);
    }

    @Override
    protected boolean canFaceDirection(Direction dir) {
        if (pipe.getNeighbourPipe(dir) != null)
            return false;

        return pipe.getFluidExtractable(dir) != EmptyFluidExtractable.NULL;
    }

    @Override
    public void tryExtract(Direction dir, int pulses) {
        ((PipeSpFlowFluid) pipe.getFlow()).tryExtract(dir);
    }
}