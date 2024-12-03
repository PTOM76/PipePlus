package net.pitan76.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeItem;
import alexiil.mc.mod.pipes.blocks.TilePipeSided;
import net.pitan76.mcpitanlib.api.sound.CompatBlockSoundGroup;
import net.pitan76.mcpitanlib.api.block.v2.CompatibleBlockSettings;
import net.pitan76.mcpitanlib.api.block.CompatibleMaterial;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;
import net.pitan76.pipeplus.blockentities.TinPipeEntity;
import net.pitan76.pipeplus.parts.PipePlusParts;

import static net.pitan76.pipeplus.PipePlus._id;

public class TinPipe extends CompatBlockPipeSided implements BlockPipeItem {
    public static CompatibleBlockSettings blockSettings = CompatibleBlockSettings.of(_id("tin_pipe"), CompatibleMaterial.DECORATION);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(CompatBlockSoundGroup.GLASS);
    }

    public TinPipe(CompatibleBlockSettings settings) {
        super(settings, PipePlusParts.TIN_ITEM_PIPE);
    }

    @Override
    public TilePipeSided createBlockEntity(TileCreateEvent event) {
        return new TinPipeEntity(event);
    }

    public static TinPipe newBlock() {
        return new TinPipe(blockSettings);
    }
}
