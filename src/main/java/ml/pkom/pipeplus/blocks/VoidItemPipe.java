package ml.pkom.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.*;
import ml.pkom.pipeplus.blockentities.VoidPipeEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.world.BlockView;

public class VoidItemPipe extends BlockPipe implements BlockPipeItem {
    public static FabricBlockSettings blockSettings = FabricBlockSettings.of(Material.SUPPORTED);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);
        blockSettings.breakByTool(FabricToolTags.PICKAXES);
        blockSettings.breakByHand(true);
    }

    public VoidItemPipe(Settings settings) {
        super(settings);
    }

    @Override
    public TilePipe createBlockEntity(BlockView view) {
        return new VoidPipeEntity();
    }

    public static Settings getSettings() {
        return blockSettings;
    }

    public static VoidItemPipe newBlock() {
        return new VoidItemPipe(getSettings());
    }
}
