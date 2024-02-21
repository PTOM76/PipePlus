package net.pitan76.pipeplus.client.model.part;

import alexiil.mc.mod.pipes.client.model.part.PipeSpPartKey;
import alexiil.mc.mod.pipes.pipe.PipeSpDef;

public class PipeSpPartKeyMutable extends PipeSpPartKey {
    public int index;
    public PipeSpPartKeyMutable(PipeSpDef def, byte isConnected, int index) {
        super(def, isConnected);
        this.index = index;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        PipeSpPartKeyMutable other = (PipeSpPartKeyMutable) obj;
        return index == other.index;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((index == -1) ? 0 : Integer.hashCode(index));
        return result;
    }
}