package net.pitan76.pipeplus.items;

import net.pitan76.mcpitanlib.api.event.item.ItemAppendTooltipEvent;
import net.pitan76.mcpitanlib.api.item.CompatibleItemSettings;
import net.pitan76.mcpitanlib.api.item.ExtendBlockItem;
import net.pitan76.mcpitanlib.api.util.TextUtil;
import net.pitan76.pipeplus.blocks.Blocks;

public class ObsidianPipe extends ExtendBlockItem {
    public ObsidianPipe(CompatibleItemSettings settings) {
        super(Blocks.OBSIDIAN_PIPE, settings);
    }

    @Override
    public void appendTooltip(ItemAppendTooltipEvent e) {
        e.tooltip.add(TextUtil.translatable("tooltip.pipeplus.obsidian_pipe"));
    }
}
