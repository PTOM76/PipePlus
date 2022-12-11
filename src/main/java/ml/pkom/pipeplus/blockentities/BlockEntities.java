package ml.pkom.pipeplus.blockentities;

import alexiil.mc.mod.pipes.blocks.SimplePipeBlocks;
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
        STACK_EXTRACT_PIPE_TILE = createTile(StackExtractPipeTile::new, Blocks.STACK_EXTRACT_PIPE);
        registerTile(STACK_EXTRACT_PIPE_TILE, "stack_extract_pipe");
        PIPE_ITEMS_TELEPORT_ENTITY = createTile(PipeItemsTeleportEntity::new, Blocks.PIPE_ITEMS_TELEPORT);
        registerTile(PIPE_ITEMS_TELEPORT_ENTITY, "pipe_items_teleport");
        EMERALD_PIPE_ENTITY = createTile(EmeraldPipeEntity::new, Blocks.EMERALD_PIPE);
        registerTile(EMERALD_PIPE_ENTITY, "emerald_pipe");
        RUBY_PIPE_ENTITY = createTile(RubyPipeEntity::new, Blocks.RUBY_PIPE);
        registerTile(RUBY_PIPE_ENTITY, "ruby_pipe");
        REDSTONE_PIPE_ENTITY = createTile(RedStonePipeEntity::new, Blocks.REDSTONE_PIPE);
        registerTile(REDSTONE_PIPE_ENTITY, "redstone_pipe");
        COBBLESTONE_PIPE_ENTITY = createTile(CobbleStonePipeEntity::new, Blocks.COBBLESTONE_PIPE);
        registerTile(COBBLESTONE_PIPE_ENTITY, "cobblestone_pipe");
        COPPER_FLUID_PIPE_ENTITY = createTile(CopperFluidPipeEntity::new, Blocks.COPPER_FLUID_PIPE);
        registerTile(COPPER_FLUID_PIPE_ENTITY, "copper_fluid_pipe");
        TIN_FLUID_PIPE_ENTITY = createTile(TinFluidPipeEntity::new, Blocks.TIN_FLUID_PIPE);
        registerTile(TIN_FLUID_PIPE_ENTITY, "tin_fluid_pipe");
        SILVER_FLUID_PIPE_ENTITY = createTile(SilverFluidPipeEntity::new, Blocks.SILVER_FLUID_PIPE);
        registerTile(SILVER_FLUID_PIPE_ENTITY, "silver_fluid_pipe");
        VOID_ITEM_PIPE_TILE_ENTITY = createTile(VoidPipeEntity::new, Blocks.VOID_ITEM_PIPE);
        registerTile(VOID_ITEM_PIPE_TILE_ENTITY, "void_item_pipe");
    }

    private static <T extends BlockEntity> BlockEntityType<T> createTile(SimplePipeBlocks.IBeCreator<T> supplier, Block... blocks) {
        return new BlockEntityType<T>(null, new HashSet<>(Arrays.asList(blocks)), null) {
            @Override
            public T instantiate(BlockPos pos, BlockState state) {
                return supplier.create(pos, state);
            }
        };
    }

    private static void registerTile(BlockEntityType<?> type, String name) {
        registry.registerBlockEntityType(PipePlus.id(name), () -> type);
    }

    private static void registerTile(BlockEntityType<?> type, Identifier id) {
        registry.registerBlockEntityType(id, () -> type);
    }

}
