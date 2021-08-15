package ml.pkom.pipeplus.blockentities;

import alexiil.mc.mod.pipes.blocks.PipeFlow;
import ml.pkom.pipeplus.classes.TeleportPipeType;

import java.util.UUID;

public interface IPipeTeleportTileEntity {

    public Integer frequency = 0;

    public PipeFlow iFlow = null;

    public default Integer getFrequency() {
        return frequency;
    }

    public boolean canReceive();

    public boolean canSend();

    public boolean isPublic();

    public UUID getOwnerUUID();

    public TeleportPipeType getPipeType();


}
