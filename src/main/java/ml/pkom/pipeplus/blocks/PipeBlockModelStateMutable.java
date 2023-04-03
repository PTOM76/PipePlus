package ml.pkom.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.TilePipe.PipeBlockModelState;
import alexiil.mc.mod.pipes.pipe.PipeSpDef;

public class PipeBlockModelStateMutable extends PipeBlockModelState {
    public int index;
    public PipeBlockModelStateMutable(PipeSpDef def, byte isConnected, int index) {
        super(def, isConnected);
        this.index = index;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        PipeBlockModelStateMutable other = (PipeBlockModelStateMutable) obj;
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
