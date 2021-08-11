package ml.pkom.pipeplus.pipeflow;

import alexiil.mc.mod.pipes.blocks.PipeFlowItem;
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