package ml.pkom.pipeplus.blockentities;

import alexiil.mc.lib.attributes.Simulation;
import alexiil.mc.lib.attributes.item.ItemExtractable;
import alexiil.mc.lib.attributes.item.impl.EmptyItemExtractable;
import alexiil.mc.mod.pipes.pipe.PipeSpFlowItem;
import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import ml.pkom.pipeplus.blocks.Blocks;
import ml.pkom.pipeplus.config.PipePlusConfig;
import ml.pkom.pipeplus.pipeflow.SilverPipeFlow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.Direction;

public class SilverPipeEntity extends ExtendTilePipeSided {
    private int needCooldown = 4;
    private int cooldown = needCooldown;

    public SilverPipeEntity(TileCreateEvent event) {
        super(BlockEntities.SILVER_PIPE_ENTITY, event, Blocks.SILVER_PIPE, SilverPipeFlow::new);
        needCooldown = PipePlusConfig.getConfig().silverTransportExtractDelay;
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
            ((PipeSpFlowItem)this.getFlow()).insertItemsForce(stack, dir, (DyeColor)null, 0.08D);
        }

    }
}
