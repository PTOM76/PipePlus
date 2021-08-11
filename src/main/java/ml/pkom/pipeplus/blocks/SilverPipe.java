package ml.pkom.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeItem;
import alexiil.mc.mod.pipes.blocks.BlockPipeSided;
import alexiil.mc.mod.pipes.blocks.TilePipeSided;
import ml.pkom.pipeplus.blockentities.CopperPipeEntity;
import ml.pkom.pipeplus.blockentities.SilverPipeEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.world.BlockView;

public class SilverPipe extends BlockPipeSided implements BlockPipeItem {
    public static FabricBlockSettings blockSettings = FabricBlockSettings.of(Material.SUPPORTED);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);
        blockSettings.breakByTool(FabricToolTags.PICKAXES);
        blockSettings.breakByHand(true);
    }

    public SilverPipe(Settings settings) {
        super(settings);
    }

    @Override
    public TilePipeSided createBlockEntity(BlockView view) {
        return new SilverPipeEntity();
    }

    public static Settings getSettings() {
        return blockSettings;
    }

    public static SilverPipe newBlock() {
        return new SilverPipe(getSettings());
    }
}
