package ml.pkom.pipeplus.guis;

import ml.pkom.mcpitanlibarch.api.entity.Player;
import ml.pkom.mcpitanlibarch.api.gui.ExtendedScreenHandler;
import ml.pkom.pipeplus.blockentities.PipeItemsTeleportEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.math.BlockPos;

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
        BlockEntity be = player.world.getBlockEntity(pos);
        if (be instanceof PipeItemsTeleportEntity)
            this.tile = (PipeItemsTeleportEntity) be;
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
