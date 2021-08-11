package ml.pkom.pipeplus.pipeflow;

import alexiil.mc.mod.pipes.blocks.PipeFlowItem;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import alexiil.mc.mod.pipes.blocks.TravellingItem;

public abstract class CustomPipeFlow extends PipeFlowItem {

    public CustomPipeFlow(TilePipe pipe) {
        super(pipe);
    }

    @Override
    abstract protected double getSpeedModifier();
}