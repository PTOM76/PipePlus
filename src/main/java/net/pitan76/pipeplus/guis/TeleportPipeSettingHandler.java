package net.pitan76.pipeplus.guis;

import alexiil.mc.lib.multipart.api.MultipartContainer;
import alexiil.mc.mod.pipes.pipe.PartSpPipe;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.math.BlockPos;
import net.pitan76.mcpitanlib.api.entity.Player;
import net.pitan76.mcpitanlib.api.gui.ExtendedScreenHandler;
import net.pitan76.pipeplus.pipe.PipeSpBehaviourTeleport;

public class TeleportPipeSettingHandler extends ExtendedScreenHandler {

    public PipeSpBehaviourTeleport behaviour;
    public Player player;

    public TeleportPipeSettingHandler(int syncId, PlayerInventory inv, PipeSpBehaviourTeleport behaviour) {
        super(PipePlusContainers.TELEPORT_PIPE_SCREEN_HANDLER, syncId);
        this.player = new Player(inv.player);
        this.behaviour = behaviour;
    }


    public TeleportPipeSettingHandler(int syncId, PlayerInventory inv, PacketByteBuf buf) {
        super(PipePlusContainers.TELEPORT_PIPE_SCREEN_HANDLER, syncId, buf);
        this.player = new Player(inv.player);
        PlayerEntity player = inv.player;
        BlockPos pos = buf.readBlockPos();

        MultipartContainer container = MultipartContainer.ATTRIBUTE.getFirstOrNull(player.getWorld(), pos);

        if (container == null)
            throw new IllegalStateException("Attempted to open a teleport pipe screen where there is no teleport pipe!");

        PartSpPipe pipe = container.getFirstPart(PartSpPipe.class);
        if (pipe == null)
            throw new IllegalStateException("Attempted to open a teleport pipe screen where there is no teleport pipe!");

        if (pipe.behaviour instanceof PipeSpBehaviourTeleport) {
            this.behaviour = (PipeSpBehaviourTeleport) pipe.behaviour;
        }
    }

    @Override
    public ItemStack quickMoveOverride(Player player, int index) {
        return ItemStack.EMPTY;
    }

    @Override
    public void close(Player player) {
        //tile.markDirty();
        super.close(player);
    }
}
