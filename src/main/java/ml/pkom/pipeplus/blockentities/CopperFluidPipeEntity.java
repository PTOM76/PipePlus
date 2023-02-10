package ml.pkom.pipeplus.blockentities;

import alexiil.mc.lib.attributes.fluid.impl.EmptyFluidExtractable;
import alexiil.mc.mod.pipes.pipe.PipeSpFlowFluid;
import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import ml.pkom.pipeplus.blocks.Blocks;
import ml.pkom.pipeplus.config.PipePlusConfig;
import net.minecraft.util.math.Direction;

public class CopperFluidPipeEntity extends ExtendTilePipeSided {
    private int needCooldown = 20;
    private int cooldown = needCooldown;

    public CopperFluidPipeEntity(TileCreateEvent event) {
        super(BlockEntities.COPPER_FLUID_PIPE_ENTITY, event, Blocks.COPPER_FLUID_PIPE, PipeSpFlowFluid::new);
        needCooldown = PipePlusConfig.getConfig().copperFluidExtractDelay;
    }

    @Override
    public void tick() {
        super.tick();
        cooldown--;
        if (cooldown <= 0) {
            cooldown = needCooldown;
            if (world == null) return;
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
