package ml.pkom.pipeplus;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import ml.pkom.pipeplus.blockentities.IPipeTeleportTileEntity;
import ml.pkom.pipeplus.classes.TeleportPipeType;

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

    public void reset() {
        for(TeleportPipeType type : TeleportPipeType.values())
        {
            pipes.get(type).clear();
        }

        frequencyNames.clear();
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
