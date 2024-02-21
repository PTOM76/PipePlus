package net.pitan76.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeItem;
import net.minecraft.sound.BlockSoundGroup;
import net.pitan76.mcpitanlib.api.block.CompatibleBlockSettings;
import net.pitan76.mcpitanlib.api.block.CompatibleMaterial;
import net.pitan76.pipeplus.parts.PipePlusParts;

public class VoidItemPipe extends ExtendBlockPipe implements BlockPipeItem {

    public static CompatibleBlockSettings blockSettings = CompatibleBlockSettings.of(CompatibleMaterial.DECORATION);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);
    }

    public VoidItemPipe(CompatibleBlockSettings settings) {
        super(settings, PipePlusParts.VOID_ITEM_PIPE);
    }

    public static VoidItemPipe newBlock() {
        return new VoidItemPipe(blockSettings);
    }
}
