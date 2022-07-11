package ml.pkom.pipeplus.items;

import ml.pkom.pipeplus.PipePlus;
import ml.pkom.pipeplus.blocks.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import ml.pkom.mcpitanlib.api.text.TextUtil;
import net.minecraft.world.World;

import java.util.List;

public class SilverPipe extends Item {
    public static Settings itemSettings = new Settings();

    static {
        itemSettings.group(PipePlus.PIPEPLUS_GROUP);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(TextUtil.translatable("tip.pipeplus.auto_extract_pipe"));
    }

    public SilverPipe(Settings settings) {
        super(settings);
    }

    public static Settings getSettings() {
        return itemSettings;
    }

    public static Item newItem() {
        return new BlockItem(Blocks.SILVER_PIPE, getSettings());
    }
}
