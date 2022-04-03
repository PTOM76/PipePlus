package ml.pkom.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeFluid;
import alexiil.mc.mod.pipes.blocks.BlockPipeSided;
import alexiil.mc.mod.pipes.blocks.TilePipeSided;
import ml.pkom.pipeplus.blockentities.CopperFluidPipeEntity;
import ml.pkom.pipeplus.parts.PipePlusParts;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class CopperFluidPipe extends BlockPipeSided implements BlockPipeFluid {
    public static FabricBlockSettings blockSettings = FabricBlockSettings.of(Material.DECORATION);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);
    }

    public CopperFluidPipe(Settings settings) {
        super(settings, PipePlusParts.COPPER_FLUID_PIPE);
    }

    @Override
    public TilePipeSided createBlockEntity(BlockPos pos, BlockState state) {
        return new CopperFluidPipeEntity(pos, state);
    }

    public static Settings getSettings() {
        return blockSettings;
    }

    public static CopperFluidPipe newBlock() {
        return new CopperFluidPipe(getSettings());
    }
}
