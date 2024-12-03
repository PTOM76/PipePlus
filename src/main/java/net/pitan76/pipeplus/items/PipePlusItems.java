package net.pitan76.pipeplus.items;

import alexiil.mc.mod.pipes.items.ItemPipePart;
import net.minecraft.item.Item;
import net.pitan76.mcpitanlib.api.item.v2.CompatibleItemSettings;
import net.pitan76.mcpitanlib.api.util.CompatIdentifier;
import net.pitan76.mcpitanlib.api.util.TextUtil;
import net.pitan76.pipeplus.PipePlus;
import net.pitan76.pipeplus.parts.PipePlusParts;

import static net.pitan76.pipeplus.PipePlus.registry;

public class PipePlusItems {
    public static CompatibleItemSettings createSettings(String id) {
        return CompatibleItemSettings.of(PipePlus._id(id)).addGroup(PipePlus.PIPEPLUS_GROUP);
    }
    
    public static ItemPipePart COPPER_PIPE = new CompatItemPipePart(createSettings("copper_pipe"), PipePlusParts.COPPER_ITEM_PIPE, TextUtil.translatable("tooltip.pipeplus.auto_extract_pipe"));;
    public static ItemPipePart TIN_PIPE = new CompatItemPipePart(createSettings("tin_pipe"), PipePlusParts.TIN_ITEM_PIPE, TextUtil.translatable("tooltip.pipeplus.auto_extract_pipe"));
    public static ItemPipePart SILVER_PIPE = new CompatItemPipePart(createSettings("silver_pipe"), PipePlusParts.SILVER_ITEM_PIPE, TextUtil.translatable("tooltip.pipeplus.auto_extract_pipe"));;
    public static ItemPipePart STACK_EXTRACT_PIPE = new CompatItemPipePart(createSettings("stack_extract_pipe"), PipePlusParts.STACK_EXTRACT_ITEM_PIPE, TextUtil.translatable("tooltip.pipeplus.auto_extract_pipe"));;
    public static ItemPipePart EMERALD_PIPE = new CompatItemPipePart(createSettings("emerald_pipe"), PipePlusParts.EMERALD_PIPE);;
    public static ItemPipePart RUBY_PIPE = new CompatItemPipePart(createSettings("ruby_pipe"), PipePlusParts.RUBY_PIPE);;
    public static ItemPipePart COBBLESTONE_PIPE = new CompatItemPipePart(createSettings("cobblestone_pipe"), PipePlusParts.COBBLESTONE_ITEM_PIPE);;
    public static ItemPipePart OBSIDIAN_PIPE = new CompatItemPipePart(createSettings("obsidian_pipe"), PipePlusParts.OBSIDIAN_ITEM_PIPE, TextUtil.translatable("tooltip.pipeplus.obsidian_pipe"));;
    public static ItemPipePart ENDER_PIPE = new CompatItemPipePart(createSettings("ender_pipe"), PipePlusParts.ENDER_PIPE, TextUtil.translatable("tooltip.pipeplus.ender_pipe"));;
    public static ItemPipePart REDSTONE_PIPE = new CompatItemPipePart(createSettings("redstone_pipe"), PipePlusParts.REDSTONE_ITEM_PIPE);;
    public static ItemPipePart PIPE_ITEMS_TELEPORT = new CompatItemPipePart(createSettings("pipe_items_teleport"), PipePlusParts.TELEPORT_ITEM_PIPE);;
    public static ItemPipePart VOID_ITEM_PIPE = new CompatItemPipePart(createSettings("void_item_pipe"), PipePlusParts.VOID_ITEM_PIPE);;

    public static ItemPipePart COPPER_FLUID_PIPE = new CompatItemPipePart(createSettings("copper_fluid_pipe"), PipePlusParts.COPPER_FLUID_PIPE, TextUtil.translatable("tooltip.pipeplus.auto_extract_fluid_pipe"));;
    public static ItemPipePart TIN_FLUID_PIPE = new CompatItemPipePart(createSettings("tin_fluid_pipe"), PipePlusParts.TIN_FLUID_PIPE, TextUtil.translatable("tooltip.pipeplus.auto_extract_fluid_pipe"));
    public static ItemPipePart SILVER_FLUID_PIPE = new CompatItemPipePart(createSettings("silver_fluid_pipe"), PipePlusParts.SILVER_FLUID_PIPE, TextUtil.translatable("tooltip.pipeplus.auto_extract_fluid_pipe"));

    public static void init() {
        register(COPPER_PIPE, "copper_pipe");
        register(TIN_PIPE, "tin_pipe");
        register(SILVER_PIPE, "silver_pipe");
        register(STACK_EXTRACT_PIPE, "stack_extract_pipe");
        register(COPPER_FLUID_PIPE, "copper_fluid_pipe");
        register(TIN_FLUID_PIPE, "tin_fluid_pipe");
        register(SILVER_FLUID_PIPE, "silver_fluid_pipe");
        register(EMERALD_PIPE, "emerald_pipe");
        register(RUBY_PIPE, "ruby_pipe");
        register(COBBLESTONE_PIPE, "cobblestone_pipe");
        register(OBSIDIAN_PIPE, "obsidian_pipe");
        register(ENDER_PIPE, "ender_pipe");
        register(REDSTONE_PIPE, "redstone_pipe");
        register(VOID_ITEM_PIPE, "void_item_pipe");
        register(PIPE_ITEMS_TELEPORT, "pipe_items_teleport");
    }

    public static void register(Item item, String id) {
        registry.registerItem(PipePlus._id(id), () -> item);
    }

    public static void register(Item item, CompatIdentifier id) {
        registry.registerItem(id, () -> item);
    }
}
