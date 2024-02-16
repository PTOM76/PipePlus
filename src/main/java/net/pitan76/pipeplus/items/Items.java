package net.pitan76.pipeplus.items;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.pitan76.mcpitanlib.api.item.CompatibleItemSettings;
import net.pitan76.mcpitanlib.api.util.ItemUtil;
import net.pitan76.pipeplus.PipePlus;
import net.pitan76.pipeplus.blocks.Blocks;

import static net.pitan76.pipeplus.PipePlus.registry;

public class Items {
    public static CompatibleItemSettings createSettings(String id) {
        return new CompatibleItemSettings().addGroup(() -> PipePlus.PIPEPLUS_GROUP, PipePlus.id(id));
    }

    public static Item COPPER_PIPE = new CopperPipe(createSettings("copper_pipe"));
    public static Item TIN_PIPE = new TinPipe(createSettings("tin_pipe"));
    public static Item SILVER_PIPE = new SilverPipe(createSettings("silver_pipe"));
    public static Item COPPER_FLUID_PIPE = new CopperFluidPipe(createSettings("copper_fluid_pipe"));
    public static Item TIN_FLUID_PIPE = new TinFluidPipe(createSettings("tin_fluid_pipe"));
    public static Item SILVER_FLUID_PIPE = new SilverFluidPipe(createSettings("silver_fluid_pipe"));
    public static Item STACK_EXTRACT_PIPE = ItemUtil.ofBlock(Blocks.STACK_EXTRACT_PIPE, createSettings("stack_extract_pipe"));
    public static Item EMERALD_PIPE = ItemUtil.ofBlock(Blocks.EMERALD_PIPE, createSettings("emerald_pipe"));
    public static Item RUBY_PIPE = ItemUtil.ofBlock(Blocks.RUBY_PIPE, createSettings("ruby_pipe"));
    public static Item COBBLESTONE_PIPE = ItemUtil.ofBlock(Blocks.COBBLESTONE_PIPE, createSettings("cobblestone_pipe"));
    public static Item OBSIDIAN_PIPE = new ObsidianPipe(createSettings("obsidian_pipe"));
    public static Item ENDER_PIPE = new EnderPipe(createSettings("ender_pipe"));
    public static Item REDSTONE_PIPE = ItemUtil.ofBlock(Blocks.REDSTONE_PIPE, createSettings("redstone_pipe"));
    public static Item PIPE_ITEMS_TELEPORT = ItemUtil.ofBlock(Blocks.PIPE_ITEMS_TELEPORT, createSettings("pipe_items_teleport"));
    public static Item VOID_ITEM_PIPE = ItemUtil.ofBlock(Blocks.VOID_ITEM_PIPE, createSettings("void_item_pipe"));

    public static void registerInit() {
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
        //CreativeTabManager.addItem(PipePlus.PIPEPLUS_GROUP, PipePlus.id(id));
        registry.registerItem(PipePlus.id(id), () -> item);
    }

    public static void register(Item item, Identifier id) {
        //CreativeTabManager.addItem(PipePlus.PIPEPLUS_GROUP, id);
        registry.registerItem(id, () -> item);
    }
}
