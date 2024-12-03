package net.pitan76.pipeplus.mixin;

import alexiil.mc.mod.pipes.SimplePipesClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.pitan76.pipeplus.PipePlus;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(SimplePipesClient.class)
public class RegisterSpritesMixin {
    @Inject(method = "registerSprites", at = @At("TAIL"), remap = false)
    private void registerSprites(SpriteAtlasTexture atlasTexture, ClientSpriteRegistryCallback.Registry registry, CallbackInfo ci) {
        registry.register(PipePlus.instance.id("block/cobblestone_pipe"));
        registry.register(PipePlus.instance.id("block/redstone_pipe"));
        registry.register(PipePlus.instance.id("block/active_redstone_pipe"));
        registry.register(PipePlus.instance.id("block/emerald_pipe"));
        registry.register(PipePlus.instance.id("block/ruby_pipe"));
        registry.register(PipePlus.instance.id("block/pipe_items_teleport"));
        registry.register(PipePlus.instance.id("block/obsidian_pipe"));
        registry.register(PipePlus.instance.id("block/ender_pipe"));
        registry.register(PipePlus.instance.id("block/copper_pipe"));
        registry.register(PipePlus.instance.id("block/copper_pipe_filled"));
        registry.register(PipePlus.instance.id("block/tin_pipe"));
        registry.register(PipePlus.instance.id("block/tin_pipe_filled"));
        registry.register(PipePlus.instance.id("block/silver_pipe"));
        registry.register(PipePlus.instance.id("block/silver_pipe_filled"));
        registry.register(PipePlus.instance.id("block/stack_extract_pipe"));
        registry.register(PipePlus.instance.id("block/stack_extract_pipe_filled"));
        registry.register(PipePlus.instance.id("block/copper_fluid_pipe"));
        registry.register(PipePlus.instance.id("block/copper_fluid_pipe_filled"));
        registry.register(PipePlus.instance.id("block/tin_fluid_pipe"));
        registry.register(PipePlus.instance.id("block/tin_fluid_pipe_filled"));
        registry.register(PipePlus.instance.id("block/silver_fluid_pipe"));
        registry.register(PipePlus.instance.id("block/silver_fluid_pipe_filled"));
        registry.register(PipePlus.instance.id("block/void_item"));
    }
}