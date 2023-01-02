package ml.pkom.pipeplus.mixin;

import alexiil.mc.mod.pipes.SimplePipesClient;
import ml.pkom.pipeplus.PipePlus;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.texture.SpriteAtlasTexture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(SimplePipesClient.class)
public class RegisterSpritesMixin {
    @Inject(method = "registerSprites", at = @At("TAIL"), remap = false)
    private void registerSprites(SpriteAtlasTexture atlasTexture, ClientSpriteRegistryCallback.Registry registry, CallbackInfo ci) {
        registry.register(PipePlus.id("pipes/cobblestone_pipe"));
        registry.register(PipePlus.id("pipes/redstone_pipe"));
        registry.register(PipePlus.id("pipes/active_redstone_pipe"));
        registry.register(PipePlus.id("pipes/emerald_pipe"));
        registry.register(PipePlus.id("pipes/ruby_pipe"));
        registry.register(PipePlus.id("pipes/pipe_items_teleport"));
        registry.register(PipePlus.id("pipes/obsidian_pipe"));
        registry.register(PipePlus.id("pipes/ender_pipe"));
        registry.register(PipePlus.id("pipes/copper_pipe"));
        registry.register(PipePlus.id("pipes/copper_pipe_filled"));
        registry.register(PipePlus.id("pipes/tin_pipe"));
        registry.register(PipePlus.id("pipes/tin_pipe_filled"));
        registry.register(PipePlus.id("pipes/silver_pipe"));
        registry.register(PipePlus.id("pipes/silver_pipe_filled"));
        registry.register(PipePlus.id("pipes/stack_extract_pipe"));
        registry.register(PipePlus.id("pipes/stack_extract_pipe_filled"));
        registry.register(PipePlus.id("pipes/copper_fluid_pipe"));
        registry.register(PipePlus.id("pipes/copper_fluid_pipe_filled"));
        registry.register(PipePlus.id("pipes/tin_fluid_pipe"));
        registry.register(PipePlus.id("pipes/tin_fluid_pipe_filled"));
        registry.register(PipePlus.id("pipes/silver_fluid_pipe"));
        registry.register(PipePlus.id("pipes/silver_fluid_pipe_filled"));
        registry.register(PipePlus.id("pipes/void_item"));
    }
}