package ml.pkom.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.*;
import ml.pkom.pipeplus.blockentities.CopperPipeEntity;
import ml.pkom.pipeplus.parts.PipePlusParts;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class CopperPipe extends BlockPipeSided implements BlockPipeItem {
    public static FabricBlockSettings blockSettings = FabricBlockSettings.of(Material.DECORATION);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);
        blockSettings.breakByTool(FabricToolTags.PICKAXES);
        blockSettings.breakByHand(true);
    }

    public CopperPipe(Settings settings) {
        super(settings, PipePlusParts.COPPER_ITEM_PIPE);
    }

    @Override
    public TilePipeSided createBlockEntity(BlockPos pos, BlockState state) {
        return new CopperPipeEntity(pos, state);
    }

    public static Settings getSettings() {
        return blockSettings;
    }

    public static CopperPipe newBlock() {
        return new CopperPipe(getSettings());
    }
}
