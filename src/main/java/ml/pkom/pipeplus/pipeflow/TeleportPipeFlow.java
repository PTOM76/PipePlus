package ml.pkom.pipeplus.pipeflow;

import alexiil.mc.mod.pipes.blocks.TilePipe;
import alexiil.mc.mod.pipes.pipe.PipeSpFlowItem;
import ml.pkom.pipeplus.PipePlus;
import ml.pkom.pipeplus.TeleportManager;
import ml.pkom.pipeplus.blockentities.IPipeTeleportTileEntity;
import ml.pkom.pipeplus.blockentities.PipeItemsTeleportEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.Direction;

public class TeleportPipeFlow extends PipeSpFlowItem {

    public PipeItemsTeleportEntity tileEntity;

    public TeleportPipeFlow(TilePipe pipe) {
        super(pipe);
        tileEntity = (PipeItemsTeleportEntity) pipe;
    }

    @Override
    public ItemStack injectItem(ItemStack stack, boolean doAdd, Direction from, DyeColor colour, double speed) {
        if (this.world().isClient() || this.world() == null)
        {
            return ItemStack.EMPTY;
        }
        if (tileEntity.canSend()) {
            ItemStack itemStack = null;
            boolean success = false;
            for ( IPipeTeleportTileEntity entity : TeleportManager.instance.getConnectedPipes(tileEntity, false, true) ) {
                if (entity instanceof PipeItemsTeleportEntity){
                    PipeItemsTeleportEntity pipe2 = PipeItemsTeleportEntity.tileMap.get(PipePlus.pos2str(((PipeItemsTeleportEntity) entity).getPos()));
                    itemStack = ((TeleportPipeFlow) pipe2.getFlow()).addItem(stack, doAdd, from, colour, speed);
                    success = true;
                    break;
                }
            }
            if (success) {
                return itemStack;

            } else {
                return super.injectItem(stack, doAdd, from, colour, speed);
            }
        } else {
            return super.injectItem(stack, doAdd, from, colour, speed);
        }
    }

    public ItemStack addItem(ItemStack stack, boolean doAdd, Direction from, DyeColor colour, double speed) {
        if (this.world().isClient() || this.world() == null)
        {
            return super.injectItem(stack, doAdd, from, colour, speed);
        }
        if (isNotConnected()) return super.injectItem(stack, doAdd, from, colour, speed);
        if (this.pipe.isConnected(Direction.UP)) from = Direction.UP;
        if (this.pipe.isConnected(Direction.DOWN)) from = Direction.DOWN;
        if (this.pipe.isConnected(Direction.NORTH)) from = Direction.NORTH;
        if (this.pipe.isConnected(Direction.SOUTH)) from = Direction.SOUTH;
        if (this.pipe.isConnected(Direction.EAST)) from = Direction.EAST;
        if (this.pipe.isConnected(Direction.WEST)) from = Direction.WEST;
        super.injectItem(stack, doAdd, from, colour, speed);
        return ItemStack.EMPTY;
    }

    public boolean isNotConnected() {
        if(this.pipe.isConnected(Direction.UP)) return false;
        if(this.pipe.isConnected(Direction.DOWN)) return false;
        if(this.pipe.isConnected(Direction.NORTH)) return false;
        if(this.pipe.isConnected(Direction.SOUTH)) return false;
        if(this.pipe.isConnected(Direction.EAST)) return false;
        if(this.pipe.isConnected(Direction.WEST)) return false;
        return true;
    }
}