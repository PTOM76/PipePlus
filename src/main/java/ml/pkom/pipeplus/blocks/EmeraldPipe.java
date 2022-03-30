package ml.pkom.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipe;
import alexiil.mc.mod.pipes.blocks.BlockPipeItem;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import ml.pkom.pipeplus.blockentities.EmeraldPipeEntity;
import ml.pkom.pipeplus.parts.PipePlusParts;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;

public class EmeraldPipe extends BlockPipe implements BlockPipeItem {
    public static FabricBlockSettings blockSettings = FabricBlockSettings.of(Material.DECORATION);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);
        

    }

    public EmeraldPipe(Settings settings) {
        super(settings, PipePlusParts.EMERALD_PIPE);
    }

    @Override
    public TilePipe createBlockEntity(BlockPos pos, BlockState state) {
        return new EmeraldPipeEntity(pos, state);
    }

    public static Settings getSettings() {
        return blockSettings;
    }

    public static EmeraldPipe newBlock() {
        return new EmeraldPipe(getSettings());
    }
}
