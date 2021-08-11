package ml.pkom.pipeplus.blockentities;

import ml.pkom.pipeplus.PipePlus;
import ml.pkom.pipeplus.blocks.Blocks;
import ml.pkom.pipeplus.blocks.PipeItemsTeleport;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Supplier;

public class BlockEntities {
    public static BlockEntityType<ObsidianPipeEntity> OBSIDIAN_PIPE_ENTITY;
    public static BlockEntityType<EnderPipeEntity> ENDER_PIPE_ENTITY;
    public static BlockEntityType<CopperPipeEntity> COPPER_PIPE_ENTITY;
    public static BlockEntityType<TinPipeEntity> TIN_PIPE_ENTITY;
    public static BlockEntityType<SilverPipeEntity> SILVER_PIPE_ENTITY;
    public static BlockEntityType<PipeItemsTeleportEntity> PIPE_ITEMS_TELEPORT_ENTITY;
    public static BlockEntityType<EmeraldPipeEntity> EMERALD_PIPE_ENTITY;
    public static BlockEntityType<RubyPipeEntity> RUBY_PIPE_ENTITY;

    public static void registerInit() {
        OBSIDIAN_PIPE_ENTITY = createTile(ObsidianPipeEntity::new, Blocks.OBSIDIAN_PIPE);
        registerTile(OBSIDIAN_PIPE_ENTITY, "obsidian_pipe");
        ENDER_PIPE_ENTITY = createTile(EnderPipeEntity::new, Blocks.ENDER_PIPE);
        registerTile(ENDER_PIPE_ENTITY, "ender_pipe");
        COPPER_PIPE_ENTITY = createTile(CopperPipeEntity::new, Blocks.COPPER_PIPE);
        registerTile(COPPER_PIPE_ENTITY, "copper_pipe");
        TIN_PIPE_ENTITY = createTile(TinPipeEntity::new, Blocks.TIN_PIPE);
        registerTile(TIN_PIPE_ENTITY, "tin_pipe");
        SILVER_PIPE_ENTITY = createTile(SilverPipeEntity::new, Blocks.SILVER_PIPE);
        registerTile(SILVER_PIPE_ENTITY, "silver_pipe");
        PIPE_ITEMS_TELEPORT_ENTITY = createTile(PipeItemsTeleportEntity::new, Blocks.PIPE_ITEMS_TELEPORT);
        registerTile(PIPE_ITEMS_TELEPORT_ENTITY, "pipe_items_teleport");
        EMERALD_PIPE_ENTITY = createTile(EmeraldPipeEntity::new, Blocks.EMERALD_PIPE);
        registerTile(EMERALD_PIPE_ENTITY, "emerald_pipe");
        RUBY_PIPE_ENTITY = createTile(RubyPipeEntity::new, Blocks.RUBY_PIPE);
        registerTile(RUBY_PIPE_ENTITY, "ruby_pipe");
    }

    private static <T extends BlockEntity> BlockEntityType<T> createTile(Supplier<T> supplier, Block blocks) {
        return new BlockEntityType<>(supplier, new HashSet<>(Arrays.asList(blocks)), null);
    }

    private static void registerTile(BlockEntityType<?> type, String name) {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, PipePlus.id(name), type);
    }

    private static void registerTile(BlockEntityType<?> type, Identifier id) {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, id, type);
    }

}
