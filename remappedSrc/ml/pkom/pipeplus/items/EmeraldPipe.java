package ml.pkom.pipeplus.items;

import ml.pkom.pipeplus.PipePlus;
import ml.pkom.pipeplus.blocks.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.List;

public class EmeraldPipe extends Item {
    public static Settings itemSettings = new Settings();

    static {
        itemSettings.group(PipePlus.PIPEPLUS_GROUP);
    }

    public EmeraldPipe(Settings settings) {
        super(settings);
    }

    public static Settings getSettings() {
        return itemSettings;
    }

    public static Item newItem() {
        return new BlockItem(Blocks.EMERALD_PIPE, getSettings());
    }
}
