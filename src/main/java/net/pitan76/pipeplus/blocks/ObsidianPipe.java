package net.pitan76.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeItem;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;
import net.pitan76.pipeplus.blockentities.ObsidianPipeEntity;
import net.pitan76.pipeplus.parts.PipePlusParts;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class ObsidianPipe extends ExtendBlockPipe implements BlockPipeItem {
    public static FabricBlockSettings blockSettings = FabricBlockSettings.of(Material.DECORATION);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);
    }

    public ObsidianPipe(Settings settings) {
        super(settings, PipePlusParts.OBSIDIAN_ITEM_PIPE);
    }

    @Override
    public TilePipe createBlockEntity(TileCreateEvent event) {
        return new ObsidianPipeEntity(event);
    }

    public static Settings getSettings() {
        return blockSettings;
    }

    public static ObsidianPipe newBlock() {
        return new ObsidianPipe(getSettings());
    }
}
