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
        registry.register(PipePlus.id("block/cobblestone_pipe"));
        registry.register(PipePlus.id("block/redstone_pipe"));
        registry.register(PipePlus.id("block/active_redstone_pipe"));
        registry.register(PipePlus.id("block/emerald_pipe"));
        registry.register(PipePlus.id("block/ruby_pipe"));
        registry.register(PipePlus.id("block/pipe_items_teleport"));
        registry.register(PipePlus.id("block/obsidian_pipe"));
        registry.register(PipePlus.id("block/ender_pipe"));
        registry.register(PipePlus.id("block/copper_pipe"));
        registry.register(PipePlus.id("block/copper_pipe_filled"));
        registry.register(PipePlus.id("block/tin_pipe"));
        registry.register(PipePlus.id("block/tin_pipe_filled"));
        registry.register(PipePlus.id("block/silver_pipe"));
        registry.register(PipePlus.id("block/silver_pipe_filled"));
        registry.register(PipePlus.id("block/stack_extract_pipe"));
        registry.register(PipePlus.id("block/stack_extract_pipe_filled"));
        registry.register(PipePlus.id("block/copper_fluid_pipe"));
        registry.register(PipePlus.id("block/copper_fluid_pipe_filled"));
        registry.register(PipePlus.id("block/tin_fluid_pipe"));
        registry.register(PipePlus.id("block/tin_fluid_pipe_filled"));
        registry.register(PipePlus.id("block/silver_fluid_pipe"));
        registry.register(PipePlus.id("block/silver_fluid_pipe_filled"));
        registry.register(PipePlus.id("block/void_item"));
    }
}