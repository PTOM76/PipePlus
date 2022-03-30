package ml.pkom.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeItem;
import alexiil.mc.mod.pipes.blocks.BlockPipeSided;
import alexiil.mc.mod.pipes.blocks.TilePipeSided;
import ml.pkom.pipeplus.blockentities.SilverPipeEntity;
import ml.pkom.pipeplus.parts.PipePlusParts;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;

public class SilverPipe extends BlockPipeSided implements BlockPipeItem {
    public static FabricBlockSettings blockSettings = FabricBlockSettings.of(Material.DECORATION);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);

    }

    public SilverPipe(Settings settings) {
        super(settings, PipePlusParts.SILVER_ITEM_PIPE);
    }

    @Override
    public TilePipeSided createBlockEntity(BlockPos pos, BlockState state) {
        return new SilverPipeEntity(pos, state);
    }

    public static Settings getSettings() {
        return blockSettings;
    }

    public static SilverPipe newBlock() {
        return new SilverPipe(getSettings());
    }
}
