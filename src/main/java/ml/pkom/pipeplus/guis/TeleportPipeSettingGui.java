package ml.pkom.pipeplus.guis;

import alexiil.mc.mod.pipes.container.ContainerTile;
import ml.pkom.pipeplus.blockentities.PipeItemsTeleportEntity;
import net.fabricmc.fabric.api.container.ContainerFactory;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;

public class TeleportPipeSettingGui extends ContainerTile<PipeItemsTeleportEntity> {

    public PipeItemsTeleportEntity tile;

    public static final ContainerFactory<ScreenHandler> FACTORY = (syncId, id, player, buffer) -> {
        BlockPos pos = buffer.readBlockPos();
        BlockEntity be = player.world.getBlockEntity(pos);
        return be instanceof PipeItemsTeleportEntity ? new TeleportPipeSettingGui(syncId, player, (PipeItemsTeleportEntity)be) : null;
    };

    protected TeleportPipeSettingGui(int syncId, PlayerEntity player, PipeItemsTeleportEntity tile) {
        super(syncId, player, tile);
        this.tile = tile;
    }



}
