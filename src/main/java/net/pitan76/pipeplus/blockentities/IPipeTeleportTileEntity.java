package net.pitan76.pipeplus.blockentities;

import alexiil.mc.mod.pipes.pipe.PipeSpFlowItem;
import net.pitan76.pipeplus.TeleportPipeType;

import java.util.UUID;

public interface IPipeTeleportTileEntity {

    public UUID getPipeUUID();

    public PipeSpFlowItem iFlow = null;

    public Integer getFrequency();

    public boolean canReceive();

    public boolean canSend();

    public boolean isPublic();

    public UUID getOwnerUUID();

    public void setOwnerNameAndUUID(UUID uuid);

    public TeleportPipeType getPipeType();


}
