package net.pitan76.pipeplus.items;

import alexiil.mc.mod.pipes.items.ItemPipePart;
import alexiil.mc.mod.pipes.pipe.PipeSpDef;
import net.minecraft.text.Text;
import net.pitan76.mcpitanlib.api.event.item.ItemAppendTooltipEvent;
import net.pitan76.mcpitanlib.api.item.v2.CompatibleItemSettings;
import net.pitan76.mcpitanlib.api.item.v2.CompatItemProvider;

import java.util.ArrayList;
import java.util.List;

public class CompatItemPipePart extends ItemPipePart implements CompatItemProvider {
    public List<Text> tooltip = new ArrayList<>();

    public CompatibleItemSettings settings;

    @Override
    public CompatibleItemSettings getCompatSettings() {
        return settings;
    }

    public CompatItemPipePart(CompatibleItemSettings settings, PipeSpDef part) {
        super(settings.build(), part);
        this.settings = settings;
    }

    public CompatItemPipePart(CompatibleItemSettings settings, PipeSpDef part, List<Text> tooltip) {
        this(settings, part);
        this.tooltip.addAll(tooltip);
    }

    public CompatItemPipePart(CompatibleItemSettings settings, PipeSpDef part, Text tooltip) {
        this(settings, part);
        this.tooltip.add(tooltip);
    }

    @Override
    public void appendTooltip(ItemAppendTooltipEvent e, Options options) {
        if (!this.tooltip.isEmpty())
            e.addTooltip(this.tooltip);
    }
}
