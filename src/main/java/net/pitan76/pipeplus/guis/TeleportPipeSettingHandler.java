package net.pitan76.pipeplus.guis;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.math.BlockPos;
import net.pitan76.mcpitanlib.api.entity.Player;
import net.pitan76.mcpitanlib.api.gui.ExtendedScreenHandler;
import net.pitan76.pipeplus.blockentities.PipeItemsTeleportEntity;

public class TeleportPipeSettingHandler extends ExtendedScreenHandler {

    public PipeItemsTeleportEntity tile;
    public Player player;

    public TeleportPipeSettingHandler(int syncId, PlayerInventory inv, PipeItemsTeleportEntity tile) {
        super(PipePlusContainers.TELEPORT_PIPE_SCREEN_HANDLER, syncId);
        this.player = new Player(inv.player);
        this.tile = tile;
    }


    public TeleportPipeSettingHandler(int syncId, PlayerInventory inv, PacketByteBuf buf) {
        super(PipePlusContainers.TELEPORT_PIPE_SCREEN_HANDLER, syncId, buf);
        this.player = new Player(inv.player);
        PlayerEntity player = inv.player;
        BlockPos pos = buf.readBlockPos();
        NbtCompound nbt = buf.readNbt();
        BlockEntity be = player.world.getBlockEntity(pos);

        if (be instanceof PipeItemsTeleportEntity) {
            this.tile = (PipeItemsTeleportEntity) be;

            if(nbt != null) {
                this.tile.loadNBT(nbt);
            }
        }
    }

    @Override
    public ItemStack quickMoveOverride(Player player, int index) {
        return ItemStack.EMPTY;
    }

    @Override
    public void close(Player player) {
        tile.markDirty();
        super.close(player);
    }
}