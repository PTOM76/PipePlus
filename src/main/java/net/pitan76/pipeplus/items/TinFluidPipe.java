package net.pitan76.pipeplus.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.pitan76.mcpitanlib.api.item.CompatibleItemSettings;
import net.pitan76.mcpitanlib.api.util.TextUtil;
import net.pitan76.pipeplus.PipePlus;
import net.pitan76.pipeplus.blocks.Blocks;

import java.util.List;

public class TinFluidPipe extends Item {
    public static CompatibleItemSettings itemSettings = new CompatibleItemSettings().addGroup(() -> PipePlus.PIPEPLUS_GROUP, PipePlus.id("tin_fluid_pipe"));


    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(TextUtil.translatable("tip.pipeplus.auto_extract_pipe"));
    }

    public TinFluidPipe(Settings settings) {
        super(settings);
    }

    public static Settings getSettings() {
        return itemSettings.build();
    }

    public static Item newItem() {
        return new BlockItem(Blocks.TIN_FLUID_PIPE, getSettings());
    }
}
