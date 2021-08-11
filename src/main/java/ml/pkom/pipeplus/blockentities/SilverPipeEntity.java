package ml.pkom.pipeplus.blockentities;

import alexiil.mc.lib.attributes.Simulation;
import alexiil.mc.lib.attributes.item.ItemExtractable;
import alexiil.mc.lib.attributes.item.impl.EmptyItemExtractable;
import alexiil.mc.mod.pipes.blocks.PipeFlowItem;
import alexiil.mc.mod.pipes.blocks.TilePipeSided;
import ml.pkom.pipeplus.blocks.Blocks;
import ml.pkom.pipeplus.pipeflow.CustomPipeFlow;
import ml.pkom.pipeplus.pipeflow.SilverPipeFlow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.Direction;

public class SilverPipeEntity extends TilePipeSided {
    private int needCooldown = 5;
    private int cooldown = needCooldown;

    public SilverPipeEntity() {
        super(BlockEntities.SILVER_PIPE_ENTITY, Blocks.SILVER_PIPE, SilverPipeFlow::new);
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

    @Override
    protected boolean canFaceDirection(Direction dir) {
        if (this.getNeighbourPipe(dir) != null) {
            return false;
        } else {
            return this.getItemExtractable(dir) != EmptyItemExtractable.NULL;
        }
    }

    public void tryExtract(Direction dir, int pulses) {
        ItemExtractable extractable = this.getItemExtractable(dir);
        ItemStack stack = extractable.attemptAnyExtraction(pulses, Simulation.ACTION);
        if (!stack.isEmpty()) {
            ((PipeFlowItem)this.flow).insertItemsForce(stack, dir, (DyeColor)null, 0.08D);
        }

    }
}
