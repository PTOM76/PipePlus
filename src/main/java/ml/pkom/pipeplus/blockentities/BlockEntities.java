package ml.pkom.pipeplus.blockentities;

import alexiil.mc.mod.pipes.blocks.SimplePipeBlocks;
import ml.pkom.mcpitanlibarch.api.tile.BlockEntityTypeBuilder;
import ml.pkom.pipeplus.PipePlus;
import ml.pkom.pipeplus.blocks.Blocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.Arrays;
import java.util.HashSet;

import static ml.pkom.pipeplus.PipePlus.registry;

public class BlockEntities {
    public static BlockEntityType<ObsidianPipeEntity> OBSIDIAN_PIPE_ENTITY;
    public static BlockEntityType<EnderPipeEntity> ENDER_PIPE_ENTITY;
    public static BlockEntityType<CopperPipeEntity> COPPER_PIPE_ENTITY;
    public static BlockEntityType<TinPipeEntity> TIN_PIPE_ENTITY;
    public static BlockEntityType<SilverPipeEntity> SILVER_PIPE_ENTITY;
    public static BlockEntityType<StackExtractPipeTile> STACK_EXTRACT_PIPE_TILE;
    public static BlockEntityType<PipeItemsTeleportEntity> PIPE_ITEMS_TELEPORT_ENTITY;
    public static BlockEntityType<EmeraldPipeEntity> EMERALD_PIPE_ENTITY;
    public static BlockEntityType<RubyPipeEntity> RUBY_PIPE_ENTITY;
    public static BlockEntityType<RedStonePipeEntity> REDSTONE_PIPE_ENTITY;
    public static BlockEntityType<CobbleStonePipeEntity> COBBLESTONE_PIPE_ENTITY;
    public static BlockEntityType<CopperFluidPipeEntity> COPPER_FLUID_PIPE_ENTITY;
    public static BlockEntityType<TinFluidPipeEntity> TIN_FLUID_PIPE_ENTITY;
    public static BlockEntityType<SilverFluidPipeEntity> SILVER_FLUID_PIPE_ENTITY;
    public static BlockEntityType<VoidPipeEntity> VOID_ITEM_PIPE_TILE_ENTITY;

    public static void registerInit() {
        OBSIDIAN_PIPE_ENTITY = BlockEntityTypeBuilder.create(ObsidianPipeEntity::new, Blocks.OBSIDIAN_PIPE).build();
        registerTile(OBSIDIAN_PIPE_ENTITY, "obsidian_pipe");
        ENDER_PIPE_ENTITY = BlockEntityTypeBuilder.create(EnderPipeEntity::new, Blocks.ENDER_PIPE).build();
        registerTile(ENDER_PIPE_ENTITY, "ender_pipe");
        COPPER_PIPE_ENTITY = BlockEntityTypeBuilder.create(CopperPipeEntity::new, Blocks.COPPER_PIPE).build();
        registerTile(COPPER_PIPE_ENTITY, "copper_pipe");
        TIN_PIPE_ENTITY = BlockEntityTypeBuilder.create(TinPipeEntity::new, Blocks.TIN_PIPE).build();
        registerTile(TIN_PIPE_ENTITY, "tin_pipe");
        SILVER_PIPE_ENTITY = BlockEntityTypeBuilder.create(SilverPipeEntity::new, Blocks.SILVER_PIPE).build();
        registerTile(SILVER_PIPE_ENTITY, "silver_pipe");
        STACK_EXTRACT_PIPE_TILE = BlockEntityTypeBuilder.create(StackExtractPipeTile::new, Blocks.STACK_EXTRACT_PIPE).build();
        registerTile(STACK_EXTRACT_PIPE_TILE, "stack_extract_pipe");
        PIPE_ITEMS_TELEPORT_ENTITY = BlockEntityTypeBuilder.create(PipeItemsTeleportEntity::new, Blocks.PIPE_ITEMS_TELEPORT).build();
        registerTile(PIPE_ITEMS_TELEPORT_ENTITY, "pipe_items_teleport");
        EMERALD_PIPE_ENTITY = BlockEntityTypeBuilder.create(EmeraldPipeEntity::new, Blocks.EMERALD_PIPE).build();
        registerTile(EMERALD_PIPE_ENTITY, "emerald_pipe");
        RUBY_PIPE_ENTITY = BlockEntityTypeBuilder.create(RubyPipeEntity::new, Blocks.RUBY_PIPE).build();
        registerTile(RUBY_PIPE_ENTITY, "ruby_pipe");
        REDSTONE_PIPE_ENTITY = BlockEntityTypeBuilder.create(RedStonePipeEntity::new, Blocks.REDSTONE_PIPE).build();
        registerTile(REDSTONE_PIPE_ENTITY, "redstone_pipe");
        COBBLESTONE_PIPE_ENTITY = BlockEntityTypeBuilder.create(CobbleStonePipeEntity::new, Blocks.COBBLESTONE_PIPE).build();
        registerTile(COBBLESTONE_PIPE_ENTITY, "cobblestone_pipe");
        COPPER_FLUID_PIPE_ENTITY = BlockEntityTypeBuilder.create(CopperFluidPipeEntity::new, Blocks.COPPER_FLUID_PIPE).build();
        registerTile(COPPER_FLUID_PIPE_ENTITY, "copper_fluid_pipe");
        TIN_FLUID_PIPE_ENTITY = BlockEntityTypeBuilder.create(TinFluidPipeEntity::new, Blocks.TIN_FLUID_PIPE).build();
        registerTile(TIN_FLUID_PIPE_ENTITY, "tin_fluid_pipe");
        SILVER_FLUID_PIPE_ENTITY = BlockEntityTypeBuilder.create(SilverFluidPipeEntity::new, Blocks.SILVER_FLUID_PIPE).build();
        registerTile(SILVER_FLUID_PIPE_ENTITY, "silver_fluid_pipe");
        VOID_ITEM_PIPE_TILE_ENTITY = BlockEntityTypeBuilder.create(VoidPipeEntity::new, Blocks.VOID_ITEM_PIPE).build();
        registerTile(VOID_ITEM_PIPE_TILE_ENTITY, "void_item_pipe");
    }

    private static void registerTile(BlockEntityType<?> type, String name) {
        registry.registerBlockEntityType(PipePlus.id(name), () -> type);
    }

    private static void registerTile(BlockEntityType<?> type, Identifier id) {
        registry.registerBlockEntityType(id, () -> type);
    }

}
