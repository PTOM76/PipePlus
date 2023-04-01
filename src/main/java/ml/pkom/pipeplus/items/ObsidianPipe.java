package ml.pkom.pipeplus.items;

import ml.pkom.mcpitanlibarch.api.event.item.ItemAppendTooltipEvent;
import ml.pkom.mcpitanlibarch.api.item.CompatibleItemSettings;
import ml.pkom.mcpitanlibarch.api.item.ExtendItem;
import ml.pkom.mcpitanlibarch.api.util.ItemUtil;
import ml.pkom.mcpitanlibarch.api.util.TextUtil;
import ml.pkom.pipeplus.PipePlus;
import ml.pkom.pipeplus.blocks.Blocks;
import net.minecraft.item.Item;

public class ObsidianPipe extends ExtendItem {
    public static CompatibleItemSettings itemSettings = new CompatibleItemSettings().
            addGroup(PipePlus.PIPEPLUS_GROUP,
                    PipePlus.id("obsidian_pipe"));

    @Override
    public void appendTooltip(ItemAppendTooltipEvent event) {
        event.tooltip.add(TextUtil.translatable("tooltip.pipeplus.obsidian_pipe"));
    }

    public ObsidianPipe(CompatibleItemSettings settings) {
        super(settings);
    }

    public static CompatibleItemSettings getSettings() {
        return itemSettings;
    }

    public static Item newItem() {
        return ItemUtil.ofBlock(Blocks.OBSIDIAN_PIPE, getSettings());
    }
}
