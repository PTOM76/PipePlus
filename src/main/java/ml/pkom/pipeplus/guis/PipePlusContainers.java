package ml.pkom.pipeplus.guis;

import ml.pkom.pipeplus.PipePlus;
import net.fabricmc.fabric.api.container.ContainerFactory;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.Identifier;

public class PipePlusContainers {
    public static final Identifier TELEPORT_PIPE = PipePlus.id("teleport_pipe");

    public PipePlusContainers() {

    }

    public static void load() {
        register(TELEPORT_PIPE, TeleportPipeSettingGui.FACTORY);
    }

    private static void register(Identifier id, ContainerFactory<ScreenHandler> factory) {
        ContainerProviderRegistry.INSTANCE.registerFactory(id, factory);
    }
}
