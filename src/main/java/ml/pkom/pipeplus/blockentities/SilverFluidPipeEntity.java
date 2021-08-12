package ml.pkom.pipeplus.blockentities;

import alexiil.mc.lib.attributes.fluid.impl.EmptyFluidExtractable;
import alexiil.mc.mod.pipes.blocks.PipeFlowFluid;
import alexiil.mc.mod.pipes.blocks.TilePipeSided;
import ml.pkom.pipeplus.blocks.Blocks;
import net.minecraft.util.math.Direction;

public class SilverFluidPipeEntity extends TilePipeSided {
    private int needCooldown = 5;
    private int cooldown = needCooldown;

    public SilverFluidPipeEntity() {
        super(BlockEntities.SILVER_FLUID_PIPE_ENTITY, Blocks.SILVER_FLUID_PIPE, PipeFlowFluid::new);
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
        ((PipeFlowFluid)this.flow).tryExtract(dir);
    }
}
