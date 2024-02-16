package net.pitan76.pipeplus.blocks;

import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.pitan76.pipeplus.PipePlus;

import static net.pitan76.pipeplus.PipePlus.registry;

public class Blocks {
    public static VoidItemPipe VOID_ITEM_PIPE = VoidItemPipe.newBlock();
    public static ObsidianPipe OBSIDIAN_PIPE = ObsidianPipe.newBlock();
    public static EnderPipe ENDER_PIPE = EnderPipe.newBlock();
    public static CopperPipe COPPER_PIPE = CopperPipe.newBlock();
    public static TinPipe TIN_PIPE = TinPipe.newBlock();
    public static SilverPipe SILVER_PIPE = SilverPipe.newBlock();
    public static StackExtractPipe STACK_EXTRACT_PIPE = StackExtractPipe.newBlock();
    public static PipeItemsTeleport PIPE_ITEMS_TELEPORT = PipeItemsTeleport.newBlock();
    public static EmeraldPipe EMERALD_PIPE = EmeraldPipe.newBlock();
    public static RubyPipe RUBY_PIPE = RubyPipe.newBlock();
    public static RedStonePipe REDSTONE_PIPE = RedStonePipe.newBlock();
    public static CobbleStonePipe COBBLESTONE_PIPE = CobbleStonePipe.newBlock();
    public static CopperFluidPipe COPPER_FLUID_PIPE = CopperFluidPipe.newBlock();
    public static TinFluidPipe TIN_FLUID_PIPE = TinFluidPipe.newBlock();
    public static SilverFluidPipe SILVER_FLUID_PIPE = SilverFluidPipe.newBlock();

    public static void registerInit() {
        register(VOID_ITEM_PIPE, "void_item_pipe");
        register(OBSIDIAN_PIPE, "obsidian_pipe");
        register(ENDER_PIPE, "ender_pipe");
        register(COPPER_PIPE, "copper_pipe");
        register(TIN_PIPE, "tin_pipe");
        register(SILVER_PIPE, "silver_pipe");
        register(STACK_EXTRACT_PIPE, "stack_extract_pipe");
        register(PIPE_ITEMS_TELEPORT, "pipe_items_teleport");
        register(EMERALD_PIPE, "emerald_pipe");
        register(RUBY_PIPE, "ruby_pipe");
        register(REDSTONE_PIPE, "redstone_pipe");
        register(COBBLESTONE_PIPE, "cobblestone_pipe");
        register(COPPER_FLUID_PIPE, "copper_fluid_pipe");
        register(TIN_FLUID_PIPE, "tin_fluid_pipe");
        register(SILVER_FLUID_PIPE, "silver_fluid_pipe");
    }

    public static void register(Block block, String id) {
        registry.registerBlock(PipePlus.id(id), () -> block);
    }
    public static void register(Block block, Identifier id) {
        registry.registerBlock(id, () -> block);
    }
}
