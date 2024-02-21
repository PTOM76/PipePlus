package net.pitan76.pipeplus.pipe;

import alexiil.mc.mod.pipes.pipe.PartSpPipe;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class PipeSpBehaviourEnder extends PipeSpBehaviourObsidian {
    private static final VoxelShape INPUT_AREA_SHAPE = Block.createCuboidShape(-48.0D, -48.0D, -48.0D, 64.0D, 64.0D, 64.0D);
    private static final VoxelShape REDSTONE_SIGNAL_INPUT_AREA_SHAPE = Block.createCuboidShape(-80.0D, -80.0D, -80.0D, 96.0D, 96.0D, 96.0D);

    public VoxelShape getInputAreaShape() {
        return INPUT_AREA_SHAPE;
    }

    public VoxelShape getRedstoneSignalInputAreaShape() {
        return REDSTONE_SIGNAL_INPUT_AREA_SHAPE;
    }

    public PipeSpBehaviourEnder(PartSpPipe pipe) {
        super(pipe);
    }
}
