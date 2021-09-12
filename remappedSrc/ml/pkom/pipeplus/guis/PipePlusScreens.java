package ml.pkom.pipeplus.guis;

import net.fabricmc.fabric.api.client.screen.ContainerScreenFactory;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.Identifier;

public class PipePlusScreens {
    public static void load() {
        register(PipePlusContainers.TELEPORT_PIPE, TeleportPipeSettingScreen.FACTORY);
    }

    private static void register(Identifier id, ContainerScreenFactory<? extends ScreenHandler> factory) {
        ScreenProviderRegistry.INSTANCE.registerFactory(id, factory);
    }
}
