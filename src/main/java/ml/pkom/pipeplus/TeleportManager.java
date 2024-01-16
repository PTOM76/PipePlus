package ml.pkom.pipeplus;

import ml.pkom.pipeplus.blockentities.IPipeTeleportTileEntity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TeleportManager {
    public static final TeleportManager instance = new TeleportManager();
    private final Map<UUID, IPipeTeleportTileEntity> allPipes = new LinkedHashMap<>();

    public List<IPipeTeleportTileEntity> getPipes(int frequency, UUID owner) {
        return allPipes
                .values()
                .stream()
                .filter(pipe -> pipe.getFrequency() == frequency)
                .filter(pipe -> pipe.getOwnerUUID().equals(owner) || pipe.isPublic())
                .toList();
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
    }
}
