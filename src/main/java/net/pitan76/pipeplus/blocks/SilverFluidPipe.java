package net.pitan76.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeFluid;
import alexiil.mc.mod.pipes.blocks.TilePipeSided;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;
import net.pitan76.pipeplus.blockentities.SilverFluidPipeEntity;
import net.pitan76.pipeplus.parts.PipePlusParts;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class SilverFluidPipe extends ExtendBlockPipeSided implements BlockPipeFluid {
    public static FabricBlockSettings blockSettings = FabricBlockSettings.of(Material.DECORATION);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);
    }

    public SilverFluidPipe(Settings settings) {
        super(settings, PipePlusParts.SILVER_FLUID_PIPE);
    }

    @Override
    public TilePipeSided createBlockEntity(TileCreateEvent event) {
        return new SilverFluidPipeEntity(event);
    }

    public static Settings getSettings() {
        return blockSettings;
    }

    public static SilverFluidPipe newBlock() {
        return new SilverFluidPipe(getSettings());
    }
}
