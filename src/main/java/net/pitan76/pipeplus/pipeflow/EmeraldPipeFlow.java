package net.pitan76.pipeplus.pipeflow;

import alexiil.mc.mod.pipes.blocks.TilePipe;

public class EmeraldPipeFlow extends CustomPipeFlow {

    public EmeraldPipeFlow(TilePipe pipe) {
        super(pipe);
    }

    @Override
    protected double getSpeedModifier() {
        return 9;
    }

}