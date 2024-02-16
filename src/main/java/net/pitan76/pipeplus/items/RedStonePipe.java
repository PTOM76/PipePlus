package net.pitan76.pipeplus.items;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.pitan76.mcpitanlib.api.item.ExtendSettings;
import net.pitan76.pipeplus.PipePlus;
import net.pitan76.pipeplus.blocks.Blocks;

public class RedStonePipe extends Item {
    public static Settings itemSettings = new ExtendSettings().
            addGroup(PipePlus.PIPEPLUS_GROUP,
                    PipePlus.id("redstone_pipe"));


    public RedStonePipe(Settings settings) {
        super(settings);
    }

    public static Settings getSettings() {
        return itemSettings;
    }

    public static Item newItem() {
        return new BlockItem(Blocks.REDSTONE_PIPE, getSettings());
    }
}
