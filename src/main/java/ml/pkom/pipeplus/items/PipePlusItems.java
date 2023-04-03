package ml.pkom.pipeplus.items;

import alexiil.mc.mod.pipes.items.ItemPipePart;
import ml.pkom.mcpitanlibarch.api.item.CompatibleItemSettings;
import ml.pkom.pipeplus.PipePlus;
import ml.pkom.pipeplus.parts.PipePlusParts;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import static ml.pkom.pipeplus.PipePlus.*;

public class PipePlusItems {
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
    public static ItemPipePart VOID_ITEM_PIPE;
    public static ItemPipePart PIPE_ITEMS_TELEPORT;

    public static ItemPipePart COPPER_FLUID_PIPE;
    public static ItemPipePart TIN_FLUID_PIPE;
    public static ItemPipePart SILVER_FLUID_PIPE;

    static {
        COPPER_PIPE = new ItemPipePart(CompatibleItemSettings.of().addGroup(PIPEPLUS_GROUP, id("copper_pipe")).build(), PipePlusParts.COPPER_ITEM_PIPE);
        TIN_PIPE = new ItemPipePart(CompatibleItemSettings.of().addGroup(PIPEPLUS_GROUP, id("tin_pipe")).build(), PipePlusParts.TIN_ITEM_PIPE);
        SILVER_PIPE = new ItemPipePart(CompatibleItemSettings.of().addGroup(PIPEPLUS_GROUP, id("silver_pipe")).build(), PipePlusParts.SILVER_ITEM_PIPE);
        STACK_EXTRACT_PIPE = new ItemPipePart(CompatibleItemSettings.of().addGroup(PIPEPLUS_GROUP, id("stack_extract_pipe")).build(), PipePlusParts.STACK_EXTRACT_ITEM_PIPE);
        EMERALD_PIPE = new ItemPipePart(CompatibleItemSettings.of().addGroup(PIPEPLUS_GROUP, id("emerald_pipe")).build(), PipePlusParts.EMERALD_PIPE);
        RUBY_PIPE = new ItemPipePart(CompatibleItemSettings.of().addGroup(PIPEPLUS_GROUP, id("ruby_pipe")).build(), PipePlusParts.RUBY_PIPE);
        COBBLESTONE_PIPE = new ItemPipePart(CompatibleItemSettings.of().addGroup(PIPEPLUS_GROUP, id("cobblestone_pipe")).build(), PipePlusParts.COBBLESTONE_ITEM_PIPE);
        OBSIDIAN_PIPE = new ItemPipePart(CompatibleItemSettings.of().addGroup(PIPEPLUS_GROUP, id("obsidian_pipe")).build(), PipePlusParts.OBSIDIAN_ITEM_PIPE);
        ENDER_PIPE = new ItemPipePart(CompatibleItemSettings.of().addGroup(PIPEPLUS_GROUP, id("ender_pipe")).build(), PipePlusParts.ENDER_PIPE);
        REDSTONE_PIPE = new ItemPipePart(CompatibleItemSettings.of().addGroup(PIPEPLUS_GROUP, id("redstone_pipe")).build(), PipePlusParts.REDSTONE_ITEM_PIPE);
        VOID_ITEM_PIPE = new ItemPipePart(CompatibleItemSettings.of().addGroup(PIPEPLUS_GROUP, id("void_item_pipe")).build(), PipePlusParts.VOID_ITEM_PIPE);
        PIPE_ITEMS_TELEPORT = new ItemPipePart(CompatibleItemSettings.of().build(), PipePlusParts.TELEPORT_ITEM_PIPE); // .addGroup(PIPEPLUS_GROUP, id("pipe_items_teleport"))

        COPPER_FLUID_PIPE = new ItemPipePart(CompatibleItemSettings.of().addGroup(PIPEPLUS_GROUP, id("copper_fluid_pipe")).build(), PipePlusParts.COPPER_FLUID_PIPE);
        TIN_FLUID_PIPE = new ItemPipePart(CompatibleItemSettings.of().addGroup(PIPEPLUS_GROUP, id("tin_fluid_pipe")).build(), PipePlusParts.TIN_FLUID_PIPE);
        SILVER_FLUID_PIPE = new ItemPipePart(CompatibleItemSettings.of().addGroup(PIPEPLUS_GROUP, id("silver_fluid_pipe")).build(), PipePlusParts.SILVER_FLUID_PIPE);
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
