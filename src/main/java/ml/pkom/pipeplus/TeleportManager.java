package ml.pkom.pipeplus;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import ml.pkom.pipeplus.blockentities.IPipeTeleportTileEntity;
import ml.pkom.pipeplus.blockentities.PipeItemsTeleportEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.logging.log4j.Level;

import java.util.*;

public class TeleportManager {
    public static final TeleportManager instance = new TeleportManager();

    private static HashMap<TeleportPipeType, Multimap<Integer, IPipeTeleportTileEntity>> pipes;

    public final Map<Integer, String> frequencyNames;

    public TeleportManager() {
        pipes = new HashMap<>();

        for(TeleportPipeType type : TeleportPipeType.values())
        {
            pipes.put(type, LinkedListMultimap.<Integer, IPipeTeleportTileEntity>create());
        }

        frequencyNames = new HashMap<Integer, String>();
    }

    private Collection<IPipeTeleportTileEntity> getPipesInChannel(int frequency, TeleportPipeType type)
    {
        return pipes.get(type).get(frequency);
    }

    public void add(IPipeTeleportTileEntity newPipe, int frequency) {
        Collection<IPipeTeleportTileEntity> pipesInChannel = pipes.get(newPipe.getPipeType()).get(frequency);
        for(Iterator<IPipeTeleportTileEntity> pipesIter = pipesInChannel.iterator(); pipesIter.hasNext(); )
        {
            IPipeTeleportTileEntity pipe = pipesIter.next();
            if(pipe.equals(newPipe))
            {
                pipesIter.remove();
            }
        }
        pipesInChannel.add(newPipe);

    }

    public void remove(IPipeTeleportTileEntity pipeToRemove, int frequency) {
        if (pipeToRemove instanceof PipeItemsTeleportEntity) {
            removeItemPipe((PipeItemsTeleportEntity) pipeToRemove, frequency);
            return;
        }
        Collection<IPipeTeleportTileEntity> pipesInChannel = pipes.get(pipeToRemove.getPipeType()).get(frequency);
        for(Iterator<IPipeTeleportTileEntity> pipesIter = pipesInChannel.iterator(); pipesIter.hasNext(); )
        {
            IPipeTeleportTileEntity pipe = pipesIter.next();
            if(pipe.equals(pipeToRemove))
            {
                pipesIter.remove();
            }
        }

    }

    // Pos, Dimension
    public void removeItemPipe(PipeItemsTeleportEntity pipeToRemove, int frequency) {
        for (IPipeTeleportTileEntity v : instance.getPipesInChannel(frequency, TeleportPipeType.ITEMS)) {
            PipeItemsTeleportEntity pipe = (PipeItemsTeleportEntity) v;
            if (pipe.getPos().equals(pipeToRemove.getPos()) && pipe.getWorld().getDimension().equals(pipeToRemove.getWorld().getDimension())) {
                instance.getPipesInChannel(frequency, TeleportPipeType.ITEMS).remove(pipe);
            }
        }
    }

    public void reset() {
        for(TeleportPipeType type : TeleportPipeType.values())
        {
            pipes.get(type).clear();
        }

        frequencyNames.clear();
    }

    // 1.17.1の方も修正必須
    public static PipeItemsTeleportEntity getItemPipeFromPos(BlockPos pos, World world, int frequency) {
        for (IPipeTeleportTileEntity v:
                instance.getPipesInChannel(frequency, TeleportPipeType.ITEMS)) {
            PipeItemsTeleportEntity pipe = (PipeItemsTeleportEntity) v;
            if (pipe.getPos().equals(pos) && pipe.getWorld().getDimension().equals(world.getDimension())) {
                if (FabricLoader.getInstance().getEnvironmentType().equals(EnvType.SERVER)) {
                    if (pipe.getWorld().isClient()) continue;
                }
                return pipe;
            }

        }
        return null;
    }

    public static void printAllPipes(int frequency) {
        for (IPipeTeleportTileEntity v:
                instance.getPipesInChannel(frequency, TeleportPipeType.ITEMS)) {
            PipeItemsTeleportEntity pipe = (PipeItemsTeleportEntity) v;
            PipePlus.log(Level.INFO, "Frequency: " + pipe.getFrequency() +
                    "\nuuid: " + pipe.getOwnerUUID() +
                    "\nname: " + pipe.ownerName +
                    "\nenv: " + (pipe.getWorld().isClient() ? "isClient" : "isServer") +
                    "\npos: " + pipe.getPos());
        }
    }

    public ArrayList<IPipeTeleportTileEntity> getConnectedPipes(IPipeTeleportTileEntity pipe, boolean includeSend, boolean includeReceive)
    {
        Collection<IPipeTeleportTileEntity> channel = getPipesInChannel(pipe.getFrequency(), pipe.getPipeType());

        ArrayList<IPipeTeleportTileEntity> connected = new ArrayList<IPipeTeleportTileEntity>();

        for(IPipeTeleportTileEntity other : channel)
        {
            if(pipe != other)
            {
                if((other.canReceive() && includeReceive) || (other.canSend() && includeSend))
                {
                    if(pipe.isPublic() ? other.isPublic() : (other.getOwnerUUID() != null && other.getOwnerUUID().equals(pipe.getOwnerUUID())))
                    {
                        connected.add(other);
                    }
                }
            }

        }
        return connected;
    }

}