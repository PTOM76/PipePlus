package net.pitan76.pipeplus.pipe;

import alexiil.mc.lib.attributes.Simulation;
import alexiil.mc.lib.attributes.item.ItemExtractable;
import alexiil.mc.lib.attributes.item.impl.EmptyItemExtractable;
import alexiil.mc.mod.pipes.pipe.PartSpPipe;
import alexiil.mc.mod.pipes.pipe.PipeSpBehaviourSided;
import alexiil.mc.mod.pipes.pipe.PipeSpFlowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;

public class PipeSpBehaviourItemExtract extends PipeSpBehaviourSided {
    private int needCooldown = 20;
    private int cooldown = needCooldown;

    private int pulses = 1;

    public PipeSpBehaviourItemExtract(PartSpPipe pipe, int time, int pulses) {
        super(pipe);
        this.needCooldown = time;
        this.pulses = pulses;
    }

    @Override
    public void tick() {
        super.tick();
        cooldown--;
        if (cooldown <= 0) {
            cooldown = needCooldown;
            if (!pipe.getPipeWorld().isClient) {
                Direction dir = currentDirection();
                if (dir != null) {
                    tryExtract(dir, pulses);
                }
            }
        }
    }

    @Override
    protected boolean canFaceDirection(Direction dir) {
        if (pipe.getNeighbourPipe(dir) != null) {
            return false;
        } else {
            return pipe.getItemExtractable(dir) != EmptyItemExtractable.NULL;
        }
    }

    public void tryExtract(Direction dir, int pulses) {
        ItemExtractable extractable = pipe.getItemExtractable(dir);
        ItemStack stack = extractable.attemptAnyExtraction(pulses, Simulation.ACTION);
        if (!stack.isEmpty()) {
            ((PipeSpFlowItem)pipe.getFlow()).insertItemsForce(stack, dir, null, 0.08D);
        }
    }
}