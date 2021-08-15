package ml.pkom.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipe;
import alexiil.mc.mod.pipes.blocks.BlockPipeItem;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import ml.pkom.pipeplus.blockentities.CobbleStonePipeEntity;
import ml.pkom.pipeplus.blockentities.EmeraldPipeEntity;
import ml.pkom.pipeplus.blockentities.RubyPipeEntity;
import ml.pkom.pipeplus.parts.PipePlusParts;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class RubyPipe extends BlockPipe implements BlockPipeItem {
    public static FabricBlockSettings blockSettings = FabricBlockSettings.of(Material.DECORATION);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);
        blockSettings.breakByTool(FabricToolTags.PICKAXES);
        blockSettings.breakByHand(true);
    }

    public RubyPipe(Settings settings) {
        super(settings, PipePlusParts.RUBY_PIPE);
    }

    public TilePipe createBlockEntity(BlockPos pos, BlockState state) {
        return new RubyPipeEntity(pos, state);
    }

    public static Settings getSettings() {
        return blockSettings;
    }

    public static RubyPipe newBlock() {
        return new RubyPipe(getSettings());
    }
}
