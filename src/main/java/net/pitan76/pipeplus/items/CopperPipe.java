package net.pitan76.pipeplus.items;

import net.pitan76.mcpitanlib.api.item.ExtendSettings;
import net.pitan76.mcpitanlib.api.util.TextUtil;
import net.pitan76.pipeplus.PipePlus;
import net.pitan76.pipeplus.blocks.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class CopperPipe extends Item {
    public static Settings itemSettings = new ExtendSettings().
            addGroup(PipePlus.PIPEPLUS_GROUP,
                    PipePlus.id("copper_pipe"));


    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(TextUtil.translatable("tip.pipeplus.auto_extract_pipe"));
    }

    public CopperPipe(Settings settings) {
        super(settings);
    }

    public static Settings getSettings() {
        return itemSettings;
    }

    public static Item newItem() {
        return new BlockItem(Blocks.COPPER_PIPE, getSettings());
    }
}
