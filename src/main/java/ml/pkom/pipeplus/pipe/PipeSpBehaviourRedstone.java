package ml.pkom.pipeplus.pipe;

import alexiil.mc.mod.pipes.pipe.PartSpPipe;
import alexiil.mc.mod.pipes.pipe.PipeSpBehaviour;
import alexiil.mc.mod.pipes.pipe.PipeSpFlowItem;
import ml.pkom.pipeplus.blocks.RedstonePipe;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PipeSpBehaviourRedstone extends PipeSpBehaviour {

    public PipeSpBehaviourRedstone(PartSpPipe pipe) {
        super(pipe);
    }
    
    @Override
    public void tick() {
        super.tick();
        World world = pipe.getPipeWorld();
        BlockPos pos = pipe.getPipePos();
        if (world == null) return;
        if (!world.isClient) {
            RedstonePipe block = ((RedstonePipe) pipe.definition.pipeBlock);
            BlockState state = world.getBlockState(pos);
            block.setRedstoneSignal(state, world, pos, !((PipeSpFlowItem) pipe.getFlow()).getAllItemsForRender().isEmpty());
            block.updatePoweredStatus(world, pos, state);
        }
    }
}
