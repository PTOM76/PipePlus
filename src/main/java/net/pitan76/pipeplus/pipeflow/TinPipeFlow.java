package net.pitan76.pipeplus.pipeflow;

import alexiil.mc.mod.pipes.blocks.TilePipe;

public class TinPipeFlow extends CustomPipeFlow {

    public TinPipeFlow(TilePipe pipe) {
        super(pipe);
    }

    @Override
    protected double getSpeedModifier() {
        return 3;
    }

}