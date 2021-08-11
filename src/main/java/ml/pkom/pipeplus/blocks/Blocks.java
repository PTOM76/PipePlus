package ml.pkom.pipeplus.blocks;

import ml.pkom.pipeplus.PipePlus;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Blocks {
    public static ObsidianPipe OBSIDIAN_PIPE = ObsidianPipe.newBlock();
    public static EnderPipe ENDER_PIPE = EnderPipe.newBlock();
    public static CopperPipe COPPER_PIPE = CopperPipe.newBlock();
    public static TinPipe TIN_PIPE = TinPipe.newBlock();
    public static SilverPipe SILVER_PIPE = SilverPipe.newBlock();
    public static PipeItemsTeleport PIPE_ITEMS_TELEPORT = PipeItemsTeleport.newBlock();
    public static EmeraldPipe EMERALD_PIPE = EmeraldPipe.newBlock();
    public static RubyPipe RUBY_PIPE = RubyPipe.newBlock();

    public static void registerInit() {
        register(OBSIDIAN_PIPE, "obsidian_pipe");
        register(ENDER_PIPE, "ender_pipe");
        register(COPPER_PIPE, "copper_pipe");
        register(TIN_PIPE, "tin_pipe");
        register(SILVER_PIPE, "silver_pipe");
        register(PIPE_ITEMS_TELEPORT, "pipe_items_teleport");
        register(EMERALD_PIPE, "emerald_pipe");
        register(RUBY_PIPE, "ruby_pipe");
    }

    public static void register(Block block, String id) {
        Registry.register(Registry.BLOCK, PipePlus.id(id), block);
    }
    public static void register(Block block, Identifier id) {
        Registry.register(Registry.BLOCK, id, block);
    }
}
