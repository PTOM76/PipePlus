package net.pitan76.pipeplus.blockentities;

import alexiil.mc.mod.pipes.blocks.PipeFlow;
import net.pitan76.pipeplus.TeleportPipeType;

import java.util.UUID;

public interface IPipeTeleportTileEntity {

    public UUID getPipeUUID();

    public PipeFlow iFlow = null;

    public Integer getFrequency();

    public boolean canReceive();

    public boolean canSend();

    public boolean isPublic();

    public UUID getOwnerUUID();

    public void setOwnerNameAndUUID(UUID uuid);

    public TeleportPipeType getPipeType();


}
