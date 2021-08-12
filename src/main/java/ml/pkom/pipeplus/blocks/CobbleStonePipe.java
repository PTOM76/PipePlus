package ml.pkom.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipe;
import alexiil.mc.mod.pipes.blocks.BlockPipeItem;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import ml.pkom.pipeplus.blockentities.CobbleStonePipeEntity;
import ml.pkom.pipeplus.blockentities.ObsidianPipeEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.world.BlockView;

public class CobbleStonePipe extends BlockPipe implements BlockPipeItem {
    public static FabricBlockSettings blockSettings = FabricBlockSettings.of(Material.SUPPORTED);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);
        blockSettings.breakByTool(FabricToolTags.PICKAXES);
        blockSettings.breakByHand(true);
    }

    public CobbleStonePipe(Settings settings) {
        super(settings);
    }

    @Override
    public TilePipe createBlockEntity(BlockView view) {
        return new CobbleStonePipeEntity();
    }

    public static Settings getSettings() {
        return blockSettings;
    }

    public static CobbleStonePipe newBlock() {
        return new CobbleStonePipe(getSettings());
    }
}
