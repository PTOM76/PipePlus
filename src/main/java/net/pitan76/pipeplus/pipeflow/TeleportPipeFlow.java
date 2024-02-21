package net.pitan76.pipeplus.pipeflow;

import alexiil.mc.mod.pipes.pipe.PartSpPipe;
import alexiil.mc.mod.pipes.pipe.PipeSpFlowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.pitan76.pipeplus.TeleportManager;
import net.pitan76.pipeplus.pipe.PipeSpBehaviourTeleport;
import net.pitan76.pipeplus.teleport.IPipeTeleport;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class TeleportPipeFlow extends PipeSpFlowItem {

    PipeSpBehaviourTeleport inputBehaviour;
    public PartSpPipe inputPipe;
    private ReentrantLock mutex = new ReentrantLock();

    public TeleportPipeFlow(PartSpPipe pipe) {
        super(pipe);
        inputPipe = pipe;
    }

    @Override
    public ItemStack injectItem(ItemStack stack, boolean doAdd, Direction from, DyeColor colour, double speed) {
        if(this.world().isClient)
            throw new IllegalStateException("Cannot inject items on the client side!");

        if (inputBehaviour == null && inputPipe.behaviour instanceof PipeSpBehaviourTeleport)
            inputBehaviour = (PipeSpBehaviourTeleport) inputPipe.behaviour;

        if (inputBehaviour == null) {
            System.out.println("inputBehaviour is null");
            return stack;
        }

        List<IPipeTeleport> behaviours = TeleportManager.instance.getPipes(inputBehaviour.getFrequency());

        for (IPipeTeleport behaviour : behaviours) {
            if (!(behaviour instanceof PipeSpBehaviourTeleport)) continue;

            PipeSpBehaviourTeleport outputBehaviour = (PipeSpBehaviourTeleport) behaviour;

            if (outputBehaviour.pipeUUID == inputBehaviour.pipeUUID) continue;
            if (!outputBehaviour.canPlayerModifyPipe(inputBehaviour.getOwnerUUID())) continue;

            //送信先と受信先の公開モードが同一でない場合は除外
            if (outputBehaviour.isPublic() != inputBehaviour.isPublic()) continue;

            try {
                lock();
                outputBehaviour.getFlow().lock();

                World targetWorld = outputBehaviour.getWorld();

                if (targetWorld == null) {
                    return stack;
                }

                //転送中にパイプが破壊された場合は中断
                if (targetWorld.getBlockEntity(outputBehaviour.getPos()) == null || world().getBlockEntity(inputBehaviour.getPos()) == null) {
                    return stack;
                }

                if (inputBehaviour.canSend() && outputBehaviour.canReceive()) {
                    ItemStack copy = stack.copy();

                    copy.setCount(0);

                    insertItemsForce(copy, from, colour, speed);

                    for (Direction value : Direction.values()) {
                        if (outputBehaviour.pipe.isConnected(value)) {
                            if(!outputBehaviour.pipe.getItemInsertable(value).wouldPartiallyAccept(stack)) {
                                continue;
                            }

                            outputBehaviour.getFlow().insertItemsForce(stack, value.getOpposite(), colour, speed);

                            return ItemStack.EMPTY;
                        }
                    }

                    outputBehaviour.getFlow().insertItemsForce(stack, from, colour, speed);

                    return ItemStack.EMPTY;

                }
            } finally {
                unlock();
                outputBehaviour.getFlow().unlock();
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