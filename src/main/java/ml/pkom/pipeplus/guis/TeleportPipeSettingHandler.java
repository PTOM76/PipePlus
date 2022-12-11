package ml.pkom.pipeplus.guis;

import alexiil.mc.mod.pipes.container.ContainerTile;
import ml.pkom.pipeplus.blockentities.PipeItemsTeleportEntity;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

public class TeleportPipeSettingHandler extends ContainerTile<PipeItemsTeleportEntity> {

    public PipeItemsTeleportEntity tile;

    public static final ExtendedScreenHandlerType.ExtendedFactory<TeleportPipeSettingHandler> FACTORY = (syncId, inv, buffer) -> {
        PlayerEntity player = inv.player;
        BlockPos pos = buffer.readBlockPos();
        BlockEntity be = player.world.getBlockEntity(pos);
        return be instanceof PipeItemsTeleportEntity ? new TeleportPipeSettingHandler(syncId, player, (PipeItemsTeleportEntity)be) : null;
    };

    public TeleportPipeSettingHandler(int syncId, PlayerEntity player, PipeItemsTeleportEntity tile) {
        super(PipePlusContainers.TELEPORT_PIPE_SCREEN_HANDLER, syncId, player, tile);
        this.tile = tile;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int index) {
        return ItemStack.EMPTY;
    }

    @Override
    public void close(PlayerEntity player) {
        tile.markDirty();
        super.close(player);
    }
}
