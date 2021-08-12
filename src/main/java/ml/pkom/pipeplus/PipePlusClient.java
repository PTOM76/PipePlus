package ml.pkom.pipeplus;

import alexiil.mc.mod.pipes.blocks.TilePipe;
import alexiil.mc.mod.pipes.client.render.PipeFluidTileRenderer;
import alexiil.mc.mod.pipes.client.render.PipeItemTileRenderer;
import ml.pkom.pipeplus.blockentities.BlockEntities;
import ml.pkom.pipeplus.blocks.Blocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;

public class PipePlusClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerItemPipeRender(BlockEntities.OBSIDIAN_PIPE_ENTITY);
        setCutoutLayer(Blocks.OBSIDIAN_PIPE);
        registerItemPipeRender(BlockEntities.ENDER_PIPE_ENTITY);
        setCutoutLayer(Blocks.ENDER_PIPE);
        registerItemPipeRender(BlockEntities.COPPER_PIPE_ENTITY);
        setCutoutLayer(Blocks.COPPER_PIPE);
        registerItemPipeRender(BlockEntities.TIN_PIPE_ENTITY);
        setCutoutLayer(Blocks.TIN_PIPE);
        registerItemPipeRender(BlockEntities.SILVER_PIPE_ENTITY);
        setCutoutLayer(Blocks.SILVER_PIPE);
        registerFluidPipeRender(BlockEntities.COPPER_FLUID_PIPE_ENTITY);
        setCutoutLayer(Blocks.COPPER_FLUID_PIPE);
        registerFluidPipeRender(BlockEntities.TIN_FLUID_PIPE_ENTITY);
        setCutoutLayer(Blocks.TIN_FLUID_PIPE);
        registerFluidPipeRender(BlockEntities.SILVER_FLUID_PIPE_ENTITY);
        setCutoutLayer(Blocks.SILVER_FLUID_PIPE);
        registerItemPipeRender(BlockEntities.EMERALD_PIPE_ENTITY);
        setCutoutLayer(Blocks.EMERALD_PIPE);
        registerItemPipeRender(BlockEntities.RUBY_PIPE_ENTITY);
        setCutoutLayer(Blocks.RUBY_PIPE);
        registerItemPipeRender(BlockEntities.REDSTONE_PIPE_ENTITY);
        setCutoutLayer(Blocks.REDSTONE_PIPE);
        registerItemPipeRender(BlockEntities.PIPE_ITEMS_TELEPORT_ENTITY);
        setCutoutLayer(Blocks.PIPE_ITEMS_TELEPORT);
        registerItemPipeRender(BlockEntities.COBBLESTONE_PIPE_ENTITY);
        setCutoutLayer(Blocks.COBBLESTONE_PIPE);
    }

    private static void setCutoutLayer(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
    }

    private static <T extends TilePipe> void registerItemPipeRender(BlockEntityType<T> type) {
        BlockEntityRendererRegistry.INSTANCE.register(type, PipeItemTileRenderer::new);
    }

    private static <T extends TilePipe> void registerFluidPipeRender(BlockEntityType<T> type) {
        BlockEntityRendererRegistry.INSTANCE.register(type, PipeFluidTileRenderer::new);
    }

}