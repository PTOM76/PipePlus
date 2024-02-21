package net.pitan76.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeFluid;
import net.minecraft.sound.BlockSoundGroup;
import net.pitan76.mcpitanlib.api.block.CompatibleBlockSettings;
import net.pitan76.mcpitanlib.api.block.CompatibleMaterial;
import net.pitan76.pipeplus.parts.PipePlusParts;

public class TinFluidPipe extends ExtendBlockPipeSided implements BlockPipeFluid {
    public static CompatibleBlockSettings blockSettings = CompatibleBlockSettings.of(CompatibleMaterial.DECORATION);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);
    }

    public TinFluidPipe(CompatibleBlockSettings settings) {
        super(settings, PipePlusParts.TIN_FLUID_PIPE);
    }


    public static TinFluidPipe newBlock() {
        return new TinFluidPipe(blockSettings);
    }
}
