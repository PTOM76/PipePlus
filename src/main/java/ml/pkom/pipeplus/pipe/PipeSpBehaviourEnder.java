package ml.pkom.pipeplus.pipe;

import alexiil.mc.mod.pipes.pipe.PartSpPipe;
import alexiil.mc.mod.pipes.pipe.PipeSpBehaviour;
import alexiil.mc.mod.pipes.pipe.TravellingItem;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

import java.util.List;
import java.util.stream.Collectors;

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
