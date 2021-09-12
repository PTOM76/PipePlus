package ml.pkom.pipeplus.pipeflow;

import alexiil.mc.mod.pipes.blocks.PipeFlowItem;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import ml.pkom.pipeplus.PipePlus;
import ml.pkom.pipeplus.TeleportManager;
import ml.pkom.pipeplus.blockentities.IPipeTeleportTileEntity;
import ml.pkom.pipeplus.blockentities.PipeItemsTeleportEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.Direction;
import org.apache.logging.log4j.Level;

public class TeleportPipeFlow extends PipeFlowItem {

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
                if (entity instanceof PipeItemsTeleportEntity) {
                    //PipeItemsTeleportEntity pipe2 = PipeItemsTeleportEntity.tileMap.get(PipePlus.pos2str(((PipeItemsTeleportEntity) entity).getPos()));
                    PipeItemsTeleportEntity pipe2 = (PipeItemsTeleportEntity) entity;
                    //PipePlus.log(Level.INFO, (pipe2.getWorld().isClient() ? "isClient" : "isServer"));
                    // 1.17.1もここで処理したほうがよかった説ある。
                    if (pipe2.getWorld().isClient()) continue;
                    // ここimportant

                    itemStack = (pipe2.getFlow()).addItem(stack, doAdd, from, colour, speed);
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
        // TeleportManager.printAllPipes(tileEntity.getFrequency());
        // 謎にWorldがクライアント判定を出すのでTeleportManagerからPosとディメーションが一致したパイプを取り出す。
        PipeItemsTeleportEntity targetPipe;
        if (pipe.getWorld().isClient()) {
            try {
                // なぜかここが解決のポイントとなった。
                PipeItemsTeleportEntity tmpPipe = TeleportManager.getItemPipeFromPos(tileEntity.getPos(), tileEntity.getWorld(), tileEntity.getFrequency());
                targetPipe = PipeItemsTeleportEntity.getTilePipe(tmpPipe.getWorld(), tileEntity.getPos());
            } catch (NullPointerException e) {
                return ItemStack.EMPTY;
            }
        } else {
            targetPipe = tileEntity;
        }
        /*
        if (pipe.getPipeWorld().isClient() || pipe.getPipeWorld() == null)
        {
            //PipePlus.log(Level.INFO, "null");
            return ItemStack.EMPTY;
            //return super.injectItem(stack, doAdd, from, colour, speed);
        }

         */
        if (targetPipe.getWorld() == null)
        {
            PipePlus.log(Level.INFO, "worldIsNull");
            return ItemStack.EMPTY;
        }
        if (targetPipe.getWorld().isClient())
        {
            PipePlus.log(Level.INFO, "isClient");
            return ItemStack.EMPTY;
        }

        if (isNotConnected(targetPipe)) return targetPipe.getFlow().superInjectItem(stack, doAdd, from, colour, speed);
        if (targetPipe.isConnected(Direction.UP)) from = Direction.UP;
        if (targetPipe.isConnected(Direction.DOWN)) from = Direction.DOWN;
        if (targetPipe.isConnected(Direction.NORTH)) from = Direction.NORTH;
        if (targetPipe.isConnected(Direction.SOUTH)) from = Direction.SOUTH;
        if (targetPipe.isConnected(Direction.EAST)) from = Direction.EAST;
        if (targetPipe.isConnected(Direction.WEST)) from = Direction.WEST;
        //PipePlus.log(Level.INFO, stack.getName().getString());

        targetPipe.getFlow().superInjectItem(stack, doAdd, from, colour, speed);
        return ItemStack.EMPTY;
    }

    public ItemStack superInjectItem(ItemStack stack, boolean doAdd, Direction from, DyeColor colour, double speed) {
        return super.injectItem(stack, doAdd, from, colour, speed);
    }

    public boolean isNotConnected(PipeItemsTeleportEntity pipe) {
        if(pipe.isConnected(Direction.UP)) return false;
        if(pipe.isConnected(Direction.DOWN)) return false;
        if(pipe.isConnected(Direction.NORTH)) return false;
        if(pipe.isConnected(Direction.SOUTH)) return false;
        if(pipe.isConnected(Direction.EAST)) return false;
        if(pipe.isConnected(Direction.WEST)) return false;
        //PipePlus.log(Level.INFO, "isNotConnected");
        return true;
    }
}