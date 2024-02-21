package net.pitan76.pipeplus.util;

import alexiil.mc.mod.pipes.pipe.PartSpPipe;
import net.minecraft.util.math.Direction;

public class PipeUtil {
    public static boolean isNotConnectedPipe(PartSpPipe pipe) {
        for (Direction value : Direction.values()) {
            if(pipe.isConnected(value)) {
                return false;
            }
        }

        return true;
    }
}
