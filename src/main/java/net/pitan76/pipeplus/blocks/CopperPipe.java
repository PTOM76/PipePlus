package net.pitan76.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeItem;
import alexiil.mc.mod.pipes.blocks.TilePipeSided;
import net.pitan76.mcpitanlib.api.sound.CompatBlockSoundGroup;
import net.pitan76.mcpitanlib.api.block.v2.CompatibleBlockSettings;
import net.pitan76.mcpitanlib.api.block.CompatibleMaterial;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;
import net.pitan76.pipeplus.blockentities.CopperPipeEntity;
import net.pitan76.pipeplus.parts.PipePlusParts;

import static net.pitan76.pipeplus.PipePlus._id;

public class CopperPipe extends CompatBlockPipeSided implements BlockPipeItem {
    public static CompatibleBlockSettings blockSettings = CompatibleBlockSettings.of(_id("copper_pipe"), CompatibleMaterial.DECORATION);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(CompatBlockSoundGroup.GLASS);
    }

    public CopperPipe(CompatibleBlockSettings settings) {
        super(settings, PipePlusParts.COPPER_ITEM_PIPE);
    }

    @Override
    public TilePipeSided createBlockEntity(TileCreateEvent event) {
        return new CopperPipeEntity(event);
    }

    public static CopperPipe newBlock() {
        return new CopperPipe(blockSettings);
    }
}
