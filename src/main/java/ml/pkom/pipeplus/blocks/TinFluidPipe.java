package ml.pkom.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeFluid;
import alexiil.mc.mod.pipes.blocks.TilePipeSided;
import ml.pkom.mcpitanlibarch.api.block.CompatibleMaterial;
import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import ml.pkom.pipeplus.blockentities.TinFluidPipeEntity;
import ml.pkom.pipeplus.parts.PipePlusParts;
import ml.pkom.mcpitanlibarch.api.block.CompatibleBlockSettings;
import net.minecraft.sound.BlockSoundGroup;

public class TinFluidPipe extends ExtendBlockPipeSided implements BlockPipeFluid {
    public static CompatibleBlockSettings blockSettings = CompatibleBlockSettings.of(CompatibleMaterial.DECORATION);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);
    }

    public TinFluidPipe(CompatibleBlockSettings settings) {
        super(settings, PipePlusParts.TIN_FLUID_PIPE);
    }

    @Override
    public TilePipeSided createBlockEntity(TileCreateEvent event) {
        return new TinFluidPipeEntity(event);
    }

    public static CompatibleBlockSettings getSettings() {
        return blockSettings;
    }

    public static TinFluidPipe newBlock() {
        return new TinFluidPipe(getSettings());
    }
}
