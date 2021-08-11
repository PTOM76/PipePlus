package ml.pkom.pipeplus.items;

import ml.pkom.pipeplus.PipePlus;
import ml.pkom.pipeplus.blocks.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class RubyPipe extends Item {
    public static Settings itemSettings = new Settings();

    static {
        itemSettings.group(PipePlus.PIPEPLUS_GROUP);
    }

    public RubyPipe(Settings settings) {
        super(settings);
    }

    public static Settings getSettings() {
        return itemSettings;
    }

    public static Item newItem() {
        return new BlockItem(Blocks.RUBY_PIPE, getSettings());
    }
}
