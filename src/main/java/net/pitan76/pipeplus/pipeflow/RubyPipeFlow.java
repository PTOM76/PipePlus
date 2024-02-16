package net.pitan76.pipeplus.pipeflow;

import alexiil.mc.mod.pipes.blocks.TilePipe;

public class RubyPipeFlow extends CustomPipeFlow {

    public RubyPipeFlow(TilePipe pipe) {
        super(pipe);
    }

    @Override
    protected double getSpeedModifier() {
        return 12;
    }

}