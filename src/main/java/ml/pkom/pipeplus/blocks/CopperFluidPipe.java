package ml.pkom.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeFluid;
import alexiil.mc.mod.pipes.blocks.BlockPipeSided;
import alexiil.mc.mod.pipes.blocks.TilePipeSided;
import ml.pkom.pipeplus.blockentities.CopperFluidPipeEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.world.BlockView;

public class CopperFluidPipe extends BlockPipeSided implements BlockPipeFluid {
    public static FabricBlockSettings blockSettings = FabricBlockSettings.of(Material.SUPPORTED);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);
        blockSettings.breakByTool(FabricToolTags.PICKAXES);
        blockSettings.breakByHand(true);
    }

    public CopperFluidPipe(Settings settings) {
        super(settings);
    }

    @Override
    public TilePipeSided createBlockEntity(BlockView view) {
        return new CopperFluidPipeEntity();
    }

    public static Settings getSettings() {
        return blockSettings;
    }

    public static CopperFluidPipe newBlock() {
        return new CopperFluidPipe(getSettings());
    }
}
