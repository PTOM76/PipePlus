package ml.pkom.pipeplus.items;

import ml.pkom.mcpitanlibarch.api.item.CompatibleItemSettings;
import ml.pkom.mcpitanlibarch.api.item.ExtendItem;
import ml.pkom.mcpitanlibarch.api.util.ItemUtil;
import ml.pkom.pipeplus.PipePlus;
import ml.pkom.pipeplus.blocks.Blocks;
import net.minecraft.item.Item;

public class PipeItemsTeleport extends ExtendItem {
    public static CompatibleItemSettings itemSettings = new CompatibleItemSettings().
            addGroup(PipePlus.PIPEPLUS_GROUP,
                    PipePlus.id("pipe_items_teleport"));

    public PipeItemsTeleport(CompatibleItemSettings settings) {
        super(settings);
    }

    public static CompatibleItemSettings getSettings() {
        return itemSettings;
    }

    public static Item newItem() {
        return ItemUtil.ofBlock(Blocks.PIPE_ITEMS_TELEPORT, getSettings());
    }
}
