package ml.pkom.pipeplus.pipeflow;

import alexiil.mc.mod.pipes.blocks.*;
import alexiil.mc.mod.pipes.pipe.PipeSpFlowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.Direction;

public class VoidPipeFlowItem extends PipeSpFlowItem {


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
