package net.pitan76.pipeplus.pipeflow;

import alexiil.mc.mod.pipes.blocks.TilePipe;

public class SilverPipeFlow extends CustomPipeFlow {

    public SilverPipeFlow(TilePipe pipe) {
        super(pipe);
    }

    @Override
    protected double getSpeedModifier() {
        return 6;
    }

}