package net.pitan76.pipeplus;

import net.pitan76.pipeplus.blockentities.IPipeTeleportTileEntity;
import net.pitan76.pipeplus.blockentities.PipeItemsTeleportEntity;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerChunkEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

import java.util.*;
import java.util.stream.Collectors;

public class TeleportManager {
    public static final TeleportManager instance = new TeleportManager();
    private static final Map<UUID, IPipeTeleportTileEntity> allPipes = new LinkedHashMap<>();
    private static final Set<UUID> unloadedPipes = new HashSet<>();
    public List<IPipeTeleportTileEntity> getPipes(int frequency) {
        return allPipes
                .values()
                .stream()
                .filter(pipe -> pipe.getFrequency() == frequency)
                .filter(pipe -> !unloadedPipes.contains(pipe.getPipeUUID()))
                .collect(Collectors.toList());
    }

    public IPipeTeleportTileEntity getPipe(UUID pipeUUID) {
        return allPipes.get(pipeUUID);
    }

    public void addPipe(IPipeTeleportTileEntity pipe) {
        allPipes.put(pipe.getPipeUUID(), pipe);
    }

    public void removePipe(IPipeTeleportTileEntity pipe) {
        allPipes.remove(pipe.getPipeUUID());
    }

    public void reset() {
        allPipes.clear();
        unloadedPipes.clear();
    }

    public static void register() {
        ServerChunkEvents.CHUNK_LOAD.register((world, chunk) -> {
            for (Map.Entry<BlockPos, BlockEntity> blockEntity : chunk.getBlockEntities().entrySet()) {
                if (!(blockEntity.getValue() instanceof IPipeTeleportTileEntity)) continue;

                IPipeTeleportTileEntity pipe = (IPipeTeleportTileEntity) blockEntity.getValue();
                unloadedPipes.remove(pipe.getPipeUUID());
            }
        });

        ServerChunkEvents.CHUNK_UNLOAD.register((world, chunk) -> {
            for (Map.Entry<BlockPos, BlockEntity> blockEntity : chunk.getBlockEntities().entrySet()) {
                if (!(blockEntity.getValue() instanceof IPipeTeleportTileEntity)) continue;

                IPipeTeleportTileEntity pipe = (IPipeTeleportTileEntity) blockEntity.getValue();
                unloadedPipes.add(pipe.getPipeUUID());
            }
        });

        PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockEntity) -> {
            if (!(blockEntity instanceof PipeItemsTeleportEntity)) return true;

            PipeItemsTeleportEntity pipeTile = (PipeItemsTeleportEntity) blockEntity;

            if (!pipeTile.canPlayerModifyPipe(player.getUuid())) return false;

            //転送中に破壊されないようにロック
            try {
                pipeTile.getFlow().lock();
                TeleportManager.instance.removePipe(pipeTile);

                return true;
            } finally {
                pipeTile.getFlow().unlock();
            }
        });
    }
}
