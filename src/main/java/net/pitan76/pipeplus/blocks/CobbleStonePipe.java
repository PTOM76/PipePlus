package net.pitan76.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeItem;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import net.minecraft.sound.BlockSoundGroup;
import net.pitan76.mcpitanlib.api.block.CompatibleBlockSettings;
import net.pitan76.mcpitanlib.api.block.CompatibleMaterial;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;
import net.pitan76.pipeplus.blockentities.CobbleStonePipeEntity;

public class CobbleStonePipe extends ExtendBlockPipe implements BlockPipeItem {
    public static CompatibleBlockSettings blockSettings = CompatibleBlockSettings.of(CompatibleMaterial.DECORATION);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);
    }

    public CobbleStonePipe(CompatibleBlockSettings settings) {
        super(settings);
    }

    @Override
    public TilePipe createBlockEntity(TileCreateEvent event) {
        return new CobbleStonePipeEntity(event);
    }

    public static CobbleStonePipe newBlock() {
        return new CobbleStonePipe(blockSettings);
    }

}
