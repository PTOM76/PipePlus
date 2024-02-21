package net.pitan76.pipeplus.items;

import alexiil.mc.mod.pipes.items.ItemPipePart;
import alexiil.mc.mod.pipes.pipe.PipeSpDef;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.pitan76.mcpitanlib.api.item.CompatibleItemSettings;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ExtendItemPipePart extends ItemPipePart {
    public List<Text> tooltip = new ArrayList<>();

    public ExtendItemPipePart(CompatibleItemSettings settings, PipeSpDef part) {
        super(settings.build(), part);
    }

    public ExtendItemPipePart(CompatibleItemSettings settings, PipeSpDef part, List<Text> tooltip) {
        super(settings.build(), part);
        this.tooltip.addAll(tooltip);
    }

    public ExtendItemPipePart(CompatibleItemSettings settings, PipeSpDef part, Text tooltip) {
        super(settings.build(), part);
        this.tooltip.add(tooltip);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        if (!this.tooltip.isEmpty())
            tooltip.addAll(this.tooltip);
    }
}
