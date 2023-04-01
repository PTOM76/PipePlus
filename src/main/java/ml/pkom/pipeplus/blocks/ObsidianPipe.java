package ml.pkom.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeItem;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import ml.pkom.mcpitanlibarch.api.block.CompatibleBlockSettings;
import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import ml.pkom.pipeplus.blockentities.ObsidianPipeEntity;
import ml.pkom.pipeplus.parts.PipePlusParts;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class ObsidianPipe extends ExtendBlockPipe implements BlockPipeItem {
    public static CompatibleBlockSettings blockSettings = CompatibleBlockSettings.of(Material.DECORATION);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);
    }

    public ObsidianPipe(CompatibleBlockSettings settings) {
        super(settings, PipePlusParts.OBSIDIAN_ITEM_PIPE);
    }

    @Override
    public TilePipe createBlockEntity(TileCreateEvent event) {
        return new ObsidianPipeEntity(event);
    }

    public static CompatibleBlockSettings getSettings() {
        return blockSettings;
    }

    public static ObsidianPipe newBlock() {
        return new ObsidianPipe(getSettings());
    }
}
