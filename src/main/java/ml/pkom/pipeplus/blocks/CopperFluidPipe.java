package ml.pkom.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeFluid;
import alexiil.mc.mod.pipes.blocks.TilePipeSided;
import ml.pkom.mcpitanlibarch.api.block.CompatibleMaterial;
import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import ml.pkom.pipeplus.blockentities.CopperFluidPipeEntity;
import ml.pkom.pipeplus.parts.PipePlusParts;
import ml.pkom.mcpitanlibarch.api.block.CompatibleBlockSettings;
import net.minecraft.sound.BlockSoundGroup;

public class CopperFluidPipe extends ExtendBlockPipeSided implements BlockPipeFluid {
    public static CompatibleBlockSettings blockSettings = CompatibleBlockSettings.of(CompatibleMaterial.DECORATION);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);
    }

    public CopperFluidPipe(CompatibleBlockSettings settings) {
        super(settings, PipePlusParts.COPPER_FLUID_PIPE);
    }

    @Override
    public TilePipeSided createBlockEntity(TileCreateEvent event) {
        return new CopperFluidPipeEntity(event);
    }

    public static CompatibleBlockSettings getSettings() {
        return blockSettings;
    }

    public static CopperFluidPipe newBlock() {
        return new CopperFluidPipe(getSettings());
    }
}
