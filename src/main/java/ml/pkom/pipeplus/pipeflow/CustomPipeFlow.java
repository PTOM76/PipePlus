package ml.pkom.pipeplus.pipeflow;

import alexiil.mc.mod.pipes.blocks.TilePipe;
import alexiil.mc.mod.pipes.pipe.PipeSpFlowItem;

public abstract class CustomPipeFlow extends PipeSpFlowItem {

    public CustomPipeFlow(TilePipe pipe) {
        super(pipe);
    }

    @Override
    abstract protected double getSpeedModifier();
}