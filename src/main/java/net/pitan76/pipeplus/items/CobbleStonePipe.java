package net.pitan76.pipeplus.items;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.pitan76.mcpitanlib.api.item.CompatibleItemSettings;
import net.pitan76.pipeplus.PipePlus;
import net.pitan76.pipeplus.blocks.Blocks;

public class CobbleStonePipe extends Item {
    public static CompatibleItemSettings itemSettings = new CompatibleItemSettings().addGroup(() -> PipePlus.PIPEPLUS_GROUP, PipePlus.id("cobblestone_pipe"));


    public CobbleStonePipe(Settings settings) {
        super(settings);
    }

    public static Settings getSettings() {
        return itemSettings.build();
    }

    public static Item newItem() {
        return new BlockItem(Blocks.COBBLESTONE_PIPE, getSettings());
    }
}
