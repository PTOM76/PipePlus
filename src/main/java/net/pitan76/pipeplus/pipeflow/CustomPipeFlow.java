package net.pitan76.pipeplus.pipeflow;

import alexiil.mc.mod.pipes.blocks.PipeFlowItem;
import alexiil.mc.mod.pipes.blocks.TilePipe;

public abstract class CustomPipeFlow extends PipeFlowItem {

    public CustomPipeFlow(TilePipe pipe) {
        super(pipe);
    }

    @Override
    abstract protected double getSpeedModifier();
}