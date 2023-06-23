package ml.pkom.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeItem;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import ml.pkom.mcpitanlibarch.api.block.CompatibleMaterial;
import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import ml.pkom.pipeplus.blockentities.RubyPipeEntity;
import ml.pkom.pipeplus.parts.PipePlusParts;
import ml.pkom.mcpitanlibarch.api.block.CompatibleBlockSettings;
import net.minecraft.sound.BlockSoundGroup;

public class RubyPipe extends ExtendBlockPipe implements BlockPipeItem {
    public static CompatibleBlockSettings blockSettings = CompatibleBlockSettings.of(CompatibleMaterial.DECORATION);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);
    }

    public RubyPipe(CompatibleBlockSettings settings) {
        super(settings, PipePlusParts.RUBY_PIPE);
    }

    public TilePipe createBlockEntity(TileCreateEvent event) {
        return new RubyPipeEntity(event);
    }

    public static CompatibleBlockSettings getSettings() {
        return blockSettings;
    }

    public static RubyPipe newBlock() {
        return new RubyPipe(getSettings());
    }
}
