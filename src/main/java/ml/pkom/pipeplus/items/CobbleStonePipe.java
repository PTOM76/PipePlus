package ml.pkom.pipeplus.items;

import ml.pkom.pipeplus.blocks.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class CobbleStonePipe extends Item {
    public static Settings itemSettings = new Settings();


    public CobbleStonePipe(Settings settings) {
        super(settings);
    }

    public static Settings getSettings() {
        return itemSettings;
    }

    public static Item newItem() {
        return new BlockItem(Blocks.COBBLESTONE_PIPE, getSettings());
    }
}
