package net.pitan76.pipeplus;

import alexiil.mc.lib.multipart.api.MultipartContainer;
import alexiil.mc.mod.pipes.pipe.PartSpPipe;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerChunkEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pitan76.pipeplus.pipe.PipeSpBehaviourTeleport;
import net.pitan76.pipeplus.teleport.IPipeTeleport;

import java.util.*;
import java.util.stream.Collectors;

public class TeleportManager {
    public static final TeleportManager instance = new TeleportManager();
    private static final Map<UUID, IPipeTeleport> allPipes = new LinkedHashMap<>();
    private static final Set<UUID> unloadedPipes = new HashSet<>();
    public List<IPipeTeleport> getPipes(int frequency) {
        return allPipes
                .values()
                .stream()
                .filter(pipe -> pipe.getFrequency() == frequency)
                .filter(pipe -> !unloadedPipes.contains(pipe.getPipeUUID()))
                .collect(Collectors.toList());
    }

    public IPipeTeleport getPipe(UUID pipeUUID) {
        return allPipes.get(pipeUUID);
    }

    public void addPipe(IPipeTeleport pipe) {
        if (allPipes.containsKey(pipe.getPipeUUID())) return;
        allPipes.put(pipe.getPipeUUID(), pipe);
    }

    public void removePipe(IPipeTeleport pipe) {
        allPipes.remove(pipe.getPipeUUID());
    }

    public void reset() {
        allPipes.clear();
        unloadedPipes.clear();
    }

    public static void register() {
        ServerChunkEvents.CHUNK_LOAD.register((world, chunk) -> {
            for (Map.Entry<BlockPos, BlockEntity> blockEntity : chunk.getBlockEntities().entrySet()) {
                if (!(blockEntity.getValue() instanceof IPipeTeleport)) continue;

                IPipeTeleport pipe = (IPipeTeleport) blockEntity.getValue();
                unloadedPipes.remove(pipe.getPipeUUID());
            }
        });

        ServerChunkEvents.CHUNK_UNLOAD.register((world, chunk) -> {
            for (Map.Entry<BlockPos, BlockEntity> blockEntity : chunk.getBlockEntities().entrySet()) {
                if (!(blockEntity.getValue() instanceof IPipeTeleport)) continue;

                IPipeTeleport pipe = (IPipeTeleport) blockEntity.getValue();
                unloadedPipes.add(pipe.getPipeUUID());
            }
        });

        PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockEntity) -> {
            PipeSpBehaviourTeleport behaviour = getPipeSpBehaviour(world, pos);
            if (behaviour == null) return true;

            if (!behaviour.canPlayerModifyPipe(player.getUuid())) return false;

            //転送中に破壊されないようにロック
            try {
                behaviour.getFlow().lock();
                TeleportManager.instance.removePipe(behaviour);

                return true;
            } finally {
                behaviour.getFlow().unlock();
            }
        });
    }

    public static PipeSpBehaviourTeleport getPipeSpBehaviour(World world, BlockPos pos) {
        MultipartContainer container = MultipartContainer.ATTRIBUTE.getFirstOrNull(world, pos);

        if (container == null) return null;

        PartSpPipe pipe = container.getFirstPart(PartSpPipe.class);
        if (pipe == null) return null;

        if (!(pipe.behaviour instanceof PipeSpBehaviourTeleport)) return null;

        return (PipeSpBehaviourTeleport) pipe.behaviour;
    }
}
