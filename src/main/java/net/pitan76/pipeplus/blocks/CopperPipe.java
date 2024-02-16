package net.pitan76.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeItem;
import alexiil.mc.mod.pipes.blocks.TilePipeSided;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;
import net.pitan76.pipeplus.blockentities.CopperPipeEntity;
import net.pitan76.pipeplus.parts.PipePlusParts;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class CopperPipe extends ExtendBlockPipeSided implements BlockPipeItem {
    public static FabricBlockSettings blockSettings = FabricBlockSettings.of(Material.DECORATION);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);
    }

    public CopperPipe(Settings settings) {
        super(settings, PipePlusParts.COPPER_ITEM_PIPE);
    }

    @Override
    public TilePipeSided createBlockEntity(TileCreateEvent event) {
        return new CopperPipeEntity(event);
    }

    public static Settings getSettings() {
        return blockSettings;
    }

    public static CopperPipe newBlock() {
        return new CopperPipe(getSettings());
    }
}
