package net.pitan76.pipeplus.pipeflow;

import alexiil.mc.mod.pipes.blocks.PipeFlowItem;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.pitan76.pipeplus.TeleportManager;
import net.pitan76.pipeplus.blockentities.IPipeTeleportTileEntity;
import net.pitan76.pipeplus.blockentities.PipeItemsTeleportEntity;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class TeleportPipeFlow extends PipeFlowItem {

    public PipeItemsTeleportEntity inputPipeTile;
    private ReentrantLock mutex = new ReentrantLock();


    public TeleportPipeFlow(TilePipe pipe) {
        super(pipe);
        inputPipeTile = (PipeItemsTeleportEntity) pipe;
    }

    @Override
    public ItemStack injectItem(ItemStack stack, boolean doAdd, Direction from, DyeColor colour, double speed) {
        if(this.world().isClient) {
            throw new IllegalStateException("Cannot inject items on the client side!");
        }

        List<IPipeTeleportTileEntity> pipes = TeleportManager.instance.getPipes(inputPipeTile.getFrequency());

        for (IPipeTeleportTileEntity pipe : pipes) {
            if (!(pipe instanceof PipeItemsTeleportEntity)) continue;

            PipeItemsTeleportEntity outputPipeTile = (PipeItemsTeleportEntity) pipe;
            if (outputPipeTile.pipeUUID == inputPipeTile.pipeUUID) continue;
            if (!outputPipeTile.canPlayerModifyPipe(inputPipeTile.getOwnerUUID())) continue;

            //送信先と受信先の公開モードが同一でない場合は除外
            if (outputPipeTile.isPublic() != inputPipeTile.isPublic()) continue;

            try {
                lock();
                outputPipeTile.getFlow().lock();

                World targetWorld = outputPipeTile.getWorld();

                if(targetWorld == null) {
                    return stack;
                }

                //転送中にパイプが破壊された場合は中断
                if (targetWorld.getBlockEntity(outputPipeTile.getPos()) == null || world().getBlockEntity(inputPipeTile.getPos()) == null) {
                    return stack;
                }

                if (inputPipeTile.canSend() && outputPipeTile.canReceive()) {
                    ItemStack copy = stack.copy();

                    copy.setCount(0);

                    insertItemsForce(copy, from, colour, speed);

                    for (Direction value : Direction.values()) {
                        if (outputPipeTile.isConnected(value)) {
                            if(!outputPipeTile.getItemInsertable(value).wouldPartiallyAccept(stack)) {
                                continue;
                            }

                            outputPipeTile.getFlow().insertItemsForce(stack, value.getOpposite(), colour, speed);

                            return ItemStack.EMPTY;
                        }
                    }

                    outputPipeTile.getFlow().insertItemsForce(stack, from, colour, speed);

                    return ItemStack.EMPTY;

                }
            } finally {
                unlock();
                outputPipeTile.getFlow().unlock();
            }
        }

        return stack;
    }

    public void lock() {
        mutex.lock();
    }

    public void unlock() {
        mutex.unlock();
    }
}