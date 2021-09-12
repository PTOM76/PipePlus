package ml.pkom.pipeplus.blockentities;

import alexiil.mc.lib.attributes.fluid.impl.EmptyFluidExtractable;
import alexiil.mc.mod.pipes.blocks.TilePipeSided;
import alexiil.mc.mod.pipes.pipe.PipeSpFlowFluid;
import ml.pkom.pipeplus.blocks.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class SilverFluidPipeEntity extends TilePipeSided {
    private int needCooldown = 5;
    private int cooldown = needCooldown;

    public SilverFluidPipeEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.SILVER_FLUID_PIPE_ENTITY, pos, state, Blocks.SILVER_FLUID_PIPE, PipeSpFlowFluid::new);
    }

    @Override
    public void tick() {
        super.tick();
        cooldown--;
        if (cooldown <= 0) {
            cooldown = needCooldown;
            if (!world.isClient) {
                Direction dir = currentDirection();
                if (dir != null) {
                    tryExtract(dir, 1);
                }
            }
        }
    }

    protected boolean canFaceDirection(Direction dir) {
        if (this.getNeighbourPipe(dir) != null) {
            return false;
        } else {
            return this.getFluidExtractable(dir) != EmptyFluidExtractable.NULL;
        }
    }

    public void tryExtract(Direction dir, int pulses) {
        ((PipeSpFlowFluid)this.getFlow()).tryExtract(dir);
    }
}
