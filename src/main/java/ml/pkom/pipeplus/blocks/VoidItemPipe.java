package ml.pkom.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.*;
import ml.pkom.pipeplus.blockentities.VoidPipeEntity;
import ml.pkom.pipeplus.parts.PipePlusParts;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;

public class VoidItemPipe extends BlockPipe implements BlockPipeItem {
    public static FabricBlockSettings blockSettings = FabricBlockSettings.of(Material.DECORATION);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);
        
    }

    public VoidItemPipe(Settings settings) {
        super(settings, PipePlusParts.VOID_ITEM_PIPE);
    }

    @Override
    public TilePipe createBlockEntity(BlockPos pos, BlockState state) {
        return new VoidPipeEntity(pos, state);
    }

    public static Settings getSettings() {
        return blockSettings;
    }

    public static VoidItemPipe newBlock() {
        return new VoidItemPipe(getSettings());
    }
}
