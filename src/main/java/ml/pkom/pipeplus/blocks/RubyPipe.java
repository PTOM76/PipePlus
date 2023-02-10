package ml.pkom.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeItem;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import ml.pkom.pipeplus.blockentities.RubyPipeEntity;
import ml.pkom.pipeplus.parts.PipePlusParts;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class RubyPipe extends ExtendBlockPipe implements BlockPipeItem {
    public static FabricBlockSettings blockSettings = FabricBlockSettings.of(Material.DECORATION);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);
    }

    public RubyPipe(Settings settings) {
        super(settings, PipePlusParts.RUBY_PIPE);
    }

    public TilePipe createBlockEntity(TileCreateEvent event) {
        return new RubyPipeEntity(event);
    }

    public static Settings getSettings() {
        return blockSettings;
    }

    public static RubyPipe newBlock() {
        return new RubyPipe(getSettings());
    }
}
