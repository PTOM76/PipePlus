package ml.pkom.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeItem;
import alexiil.mc.mod.pipes.blocks.TilePipeSided;
import ml.pkom.mcpitanlibarch.api.block.CompatibleMaterial;
import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import ml.pkom.pipeplus.blockentities.SilverPipeEntity;
import ml.pkom.pipeplus.parts.PipePlusParts;
import ml.pkom.mcpitanlibarch.api.block.CompatibleBlockSettings;
import net.minecraft.sound.BlockSoundGroup;

public class SilverPipe extends ExtendBlockPipeSided implements BlockPipeItem {
    public static CompatibleBlockSettings blockSettings = CompatibleBlockSettings.of(CompatibleMaterial.DECORATION);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);
    }

    public SilverPipe(CompatibleBlockSettings settings) {
        super(settings, PipePlusParts.SILVER_ITEM_PIPE);
    }

    @Override
    public TilePipeSided createBlockEntity(TileCreateEvent event) {
        return new SilverPipeEntity(event);
    }

    public static CompatibleBlockSettings getSettings() {
        return blockSettings;
    }

    public static SilverPipe newBlock() {
        return new SilverPipe(getSettings());
    }
}
