package net.pitan76.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeItem;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;
import net.pitan76.pipeplus.blockentities.CobbleStonePipeEntity;
import net.pitan76.pipeplus.parts.PipePlusParts;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class CobbleStonePipe extends ExtendBlockPipe implements BlockPipeItem {
    public static FabricBlockSettings blockSettings = FabricBlockSettings.of(Material.DECORATION);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);
    }

    public CobbleStonePipe(Settings settings) {
        super(settings, PipePlusParts.COBBLESTONE_ITEM_PIPE);
    }

    @Override
    public TilePipe createBlockEntity(TileCreateEvent event) {
        return new CobbleStonePipeEntity(event);
    }

    public static Settings getSettings() {
        return blockSettings;
    }

    public static CobbleStonePipe newBlock() {
        return new CobbleStonePipe(getSettings());
    }

}
