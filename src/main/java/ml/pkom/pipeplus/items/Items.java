package ml.pkom.pipeplus.items;

import ml.pkom.pipeplus.PipePlus;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Items {
    public static Item COPPER_PIPE = CopperPipe.newItem();
    public static Item TIN_PIPE = TinPipe.newItem();
    public static Item SILVER_PIPE = SilverPipe.newItem();
    public static Item EMERALD_PIPE = EmeraldPipe.newItem();
    public static Item RUBY_PIPE = RubyPipe.newItem();
    public static Item OBSIDIAN_PIPE = ObsidianPipe.newItem();
    public static Item ENDER_PIPE = EnderPipe.newItem();
    public static Item PIPE_ITEMS_TELEPORT = PipeItemsTeleport.newItem();

    public static void registerInit() {
        register(COPPER_PIPE, "copper_pipe");
        register(TIN_PIPE, "tin_pipe");
        register(SILVER_PIPE, "silver_pipe");
        register(EMERALD_PIPE, "emerald_pipe");
        register(RUBY_PIPE, "ruby_pipe");
        register(OBSIDIAN_PIPE, "obsidian_pipe");
        register(ENDER_PIPE, "ender_pipe");
        register(PIPE_ITEMS_TELEPORT, "pipe_items_teleport");
    }

    public static void register(Item item, String id) {
        Registry.register(Registry.ITEM, PipePlus.id(id), item);
    }
    public static void register(Item item, Identifier id) {
        Registry.register(Registry.ITEM, id, item);
    }
}
