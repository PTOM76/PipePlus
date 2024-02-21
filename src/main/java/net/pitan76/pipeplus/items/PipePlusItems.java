package net.pitan76.pipeplus.items;

import alexiil.mc.mod.pipes.items.ItemPipePart;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.pitan76.mcpitanlib.api.item.CompatibleItemSettings;
import net.pitan76.mcpitanlib.api.util.TextUtil;
import net.pitan76.pipeplus.PipePlus;
import net.pitan76.pipeplus.parts.PipePlusParts;

import static net.pitan76.pipeplus.PipePlus.registry;

public class PipePlusItems {
    public static CompatibleItemSettings createSettings() {
        return new CompatibleItemSettings().addGroup(PipePlus.PIPEPLUS_GROUP);
    }
    
    public static ItemPipePart COPPER_PIPE;
    public static ItemPipePart TIN_PIPE;
    public static ItemPipePart SILVER_PIPE;
    public static ItemPipePart STACK_EXTRACT_PIPE;
    public static ItemPipePart EMERALD_PIPE;
    public static ItemPipePart RUBY_PIPE;
    public static ItemPipePart COBBLESTONE_PIPE;
    public static ItemPipePart OBSIDIAN_PIPE;
    public static ItemPipePart ENDER_PIPE;
    public static ItemPipePart REDSTONE_PIPE;
    public static ItemPipePart PIPE_ITEMS_TELEPORT;
    public static ItemPipePart VOID_ITEM_PIPE;

    public static ItemPipePart COPPER_FLUID_PIPE;
    public static ItemPipePart TIN_FLUID_PIPE;
    public static ItemPipePart SILVER_FLUID_PIPE;

    static {
        COPPER_PIPE = new ExtendItemPipePart(createSettings(), PipePlusParts.COPPER_ITEM_PIPE, TextUtil.translatable("tooltip.pipeplus.auto_extract_pipe"));
        TIN_PIPE = new ExtendItemPipePart(createSettings(), PipePlusParts.TIN_ITEM_PIPE, TextUtil.translatable("tooltip.pipeplus.auto_extract_pipe"));
        SILVER_PIPE = new ExtendItemPipePart(createSettings(), PipePlusParts.SILVER_ITEM_PIPE, TextUtil.translatable("tooltip.pipeplus.auto_extract_pipe"));
        STACK_EXTRACT_PIPE = new ExtendItemPipePart(createSettings(), PipePlusParts.STACK_EXTRACT_ITEM_PIPE, TextUtil.translatable("tooltip.pipeplus.auto_extract_pipe"));
        EMERALD_PIPE = new ExtendItemPipePart(createSettings(), PipePlusParts.EMERALD_PIPE);
        RUBY_PIPE = new ExtendItemPipePart(createSettings(), PipePlusParts.RUBY_PIPE);
        COBBLESTONE_PIPE = new ExtendItemPipePart(createSettings(), PipePlusParts.COBBLESTONE_ITEM_PIPE);
        OBSIDIAN_PIPE = new ExtendItemPipePart(createSettings(), PipePlusParts.OBSIDIAN_ITEM_PIPE, TextUtil.translatable("tooltip.pipeplus.obsidian_pipe"));
        ENDER_PIPE = new ExtendItemPipePart(createSettings(), PipePlusParts.ENDER_PIPE, TextUtil.translatable("tooltip.pipeplus.ender_pipe"));
        REDSTONE_PIPE = new ExtendItemPipePart(createSettings(), PipePlusParts.REDSTONE_ITEM_PIPE);
        PIPE_ITEMS_TELEPORT = new ExtendItemPipePart(createSettings(), PipePlusParts.TELEPORT_ITEM_PIPE);
        VOID_ITEM_PIPE = new ExtendItemPipePart(createSettings(), PipePlusParts.VOID_ITEM_PIPE);

        COPPER_FLUID_PIPE = new ExtendItemPipePart(createSettings(), PipePlusParts.COPPER_FLUID_PIPE, TextUtil.translatable("tooltip.pipeplus.auto_extract_fluid_pipe"));
        TIN_FLUID_PIPE = new ExtendItemPipePart(createSettings(), PipePlusParts.TIN_FLUID_PIPE, TextUtil.translatable("tooltip.pipeplus.auto_extract_fluid_pipe"));
        SILVER_FLUID_PIPE = new ExtendItemPipePart(createSettings(), PipePlusParts.SILVER_FLUID_PIPE, TextUtil.translatable("tooltip.pipeplus.auto_extract_fluid_pipe"));
    }

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
        registry.registerItem(PipePlus.id(id), () -> item);
    }
    public static void register(Item item, Identifier id) {
        registry.registerItem(id, () -> item);
    }
}
