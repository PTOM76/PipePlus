package net.pitan76.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeItem;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import net.pitan76.mcpitanlib.api.sound.CompatBlockSoundGroup;
import net.pitan76.mcpitanlib.api.block.v2.CompatibleBlockSettings;
import net.pitan76.mcpitanlib.api.block.CompatibleMaterial;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;
import net.pitan76.pipeplus.blockentities.RubyPipeEntity;
import net.pitan76.pipeplus.parts.PipePlusParts;

import static net.pitan76.pipeplus.PipePlus._id;

public class RubyPipe extends CompatBlockPipe implements BlockPipeItem {
    public static CompatibleBlockSettings blockSettings = CompatibleBlockSettings.of(_id("ruby_pipe"), CompatibleMaterial.DECORATION);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(CompatBlockSoundGroup.GLASS);
    }

    public RubyPipe(CompatibleBlockSettings settings) {
        super(settings, PipePlusParts.RUBY_PIPE);
    }

    public TilePipe createBlockEntity(TileCreateEvent event) {
        return new RubyPipeEntity(event);
    }

    public static RubyPipe newBlock() {
        return new RubyPipe(blockSettings);
    }
}
