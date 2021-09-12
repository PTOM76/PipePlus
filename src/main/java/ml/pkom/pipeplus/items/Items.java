package ml.pkom.pipeplus.items;

import ml.pkom.pipeplus.PipePlus;
import ml.pkom.pipeplus.blocks.Blocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Items {
    public static Item COPPER_PIPE = CopperPipe.newItem();
    public static Item TIN_PIPE = TinPipe.newItem();
    public static Item SILVER_PIPE = SilverPipe.newItem();
    public static Item COPPER_FLUID_PIPE = CopperFluidPipe.newItem();
    public static Item TIN_FLUID_PIPE = TinFluidPipe.newItem();
    public static Item SILVER_FLUID_PIPE = SilverFluidPipe.newItem();
    public static Item EMERALD_PIPE = EmeraldPipe.newItem();
    public static Item RUBY_PIPE = RubyPipe.newItem();
    public static Item COBBLESTONE_PIPE = CobbleStonePipe.newItem();
    public static Item OBSIDIAN_PIPE = ObsidianPipe.newItem();
    public static Item ENDER_PIPE = EnderPipe.newItem();
    public static Item REDSTONE_PIPE = RedStonePipe.newItem();
    public static Item PIPE_ITEMS_TELEPORT = PipeItemsTeleport.newItem();
    public static Item VOID_ITEM_PIPE = new BlockItem(Blocks.VOID_ITEM_PIPE, new Item.Settings().group(PipePlus.PIPEPLUS_GROUP));

    public static Item DEBUG_ITEM = DebugItem.newItem();

    public static void registerInit() {
        register(COPPER_PIPE, "copper_pipe");
        register(TIN_PIPE, "tin_pipe");
        register(SILVER_PIPE, "silver_pipe");
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

        register(DEBUG_ITEM, "debug_item");
    }

    public static void register(Item item, String id) {
        Registry.register(Registry.ITEM, PipePlus.id(id), item);
    }
    public static void register(Item item, Identifier id) {
        Registry.register(Registry.ITEM, id, item);
    }
}
