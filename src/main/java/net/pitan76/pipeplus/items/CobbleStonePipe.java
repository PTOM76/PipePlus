package net.pitan76.pipeplus.items;

import net.pitan76.mcpitanlib.api.item.ExtendSettings;
import net.pitan76.pipeplus.PipePlus;
import net.pitan76.pipeplus.blocks.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class CobbleStonePipe extends Item {
    public static Settings itemSettings = new ExtendSettings().addGroup(PipePlus.PIPEPLUS_GROUP, PipePlus.id("cobblestone_pipe"));


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
