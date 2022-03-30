package ml.pkom.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipe;
import alexiil.mc.mod.pipes.blocks.BlockPipeItem;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import ml.pkom.pipeplus.blockentities.EnderPipeEntity;
import ml.pkom.pipeplus.blockentities.ObsidianPipeEntity;
import ml.pkom.pipeplus.parts.PipePlusParts;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class EnderPipe extends BlockPipe implements BlockPipeItem {
    public static FabricBlockSettings blockSettings = FabricBlockSettings.of(Material.DECORATION);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);

    }

    public EnderPipe(Settings settings) {
        super(settings, PipePlusParts.ENDER_PIPE);
    }

    @Override
    public TilePipe createBlockEntity(BlockPos pos, BlockState state) {
        return new EnderPipeEntity(pos, state);
    }

    public static Settings getSettings() {
        return blockSettings;
    }

    public static EnderPipe newBlock() {
        return new EnderPipe(getSettings());
    }
}
