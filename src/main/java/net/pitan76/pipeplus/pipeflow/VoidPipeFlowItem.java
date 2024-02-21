package net.pitan76.pipeplus.pipeflow;

import alexiil.mc.mod.pipes.blocks.PipeFlowItem;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.Direction;

public class VoidPipeFlowItem extends PipeFlowItem {


    public VoidPipeFlowItem(TilePipe pipe) {
        super(pipe);
    }

    public ItemStack injectItem(ItemStack stack, boolean doAdd, Direction from, DyeColor colour, double speed) {
        if (this.world().isClient) {
            throw new IllegalStateException("Cannot inject items on the client side!");
        }
        return ItemStack.EMPTY;
    }

    public void insertItemsForce(ItemStack stack, Direction from, DyeColor colour, double speed) {
        if (this.world().isClient) {
            throw new IllegalStateException("Cannot inject items on the client side!");
        } else if (!stack.isEmpty()) {
            return;
        }
    }
}
