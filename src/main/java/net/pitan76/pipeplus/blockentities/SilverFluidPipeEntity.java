package net.pitan76.pipeplus.blockentities;

import alexiil.mc.lib.attributes.fluid.impl.EmptyFluidExtractable;
import alexiil.mc.mod.pipes.pipe.PipeSpFlowFluid;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;
import net.pitan76.pipeplus.blocks.Blocks;
import net.pitan76.pipeplus.config.PipePlusConfig;
import net.minecraft.util.math.Direction;

public class SilverFluidPipeEntity extends ExtendTilePipeSided {
    private int needCooldown = 4;
    private int cooldown = needCooldown;

    public SilverFluidPipeEntity(TileCreateEvent event) {
        super(BlockEntities.SILVER_FLUID_PIPE_ENTITY, event, Blocks.SILVER_FLUID_PIPE, PipeSpFlowFluid::new);
        needCooldown = PipePlusConfig.getConfig().silverFluidExtractDelay;
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
