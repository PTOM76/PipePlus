package ml.pkom.pipeplus.blockentities;

import alexiil.mc.lib.attributes.Simulation;
import alexiil.mc.lib.attributes.fluid.impl.EmptyFluidExtractable;
import alexiil.mc.lib.attributes.item.ItemExtractable;
import alexiil.mc.lib.attributes.item.impl.EmptyItemExtractable;
import alexiil.mc.mod.pipes.blocks.PipeFlowFluid;
import alexiil.mc.mod.pipes.blocks.PipeFlowItem;
import alexiil.mc.mod.pipes.blocks.TilePipeSided;
import ml.pkom.pipeplus.blocks.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.Direction;

public class CopperFluidPipeEntity extends TilePipeSided {
    private int needCooldown = 20;
    private int cooldown = needCooldown;

    public CopperFluidPipeEntity() {
        super(BlockEntities.COPPER_FLUID_PIPE_ENTITY, Blocks.COPPER_FLUID_PIPE, PipeFlowFluid::new);
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
