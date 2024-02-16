package net.pitan76.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeItem;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;
import net.pitan76.pipeplus.blockentities.EnderPipeEntity;
import net.pitan76.pipeplus.parts.PipePlusParts;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class EnderPipe extends ExtendBlockPipe implements BlockPipeItem {
    public static FabricBlockSettings blockSettings = FabricBlockSettings.of(Material.DECORATION);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);
    }

    public EnderPipe(Settings settings) {
        super(settings, PipePlusParts.ENDER_PIPE);
    }

    @Override
    public TilePipe createBlockEntity(TileCreateEvent event) {
        return new EnderPipeEntity(event);
    }

    public static Settings getSettings() {
        return blockSettings;
    }

    public static EnderPipe newBlock() {
        return new EnderPipe(getSettings());
    }
}
