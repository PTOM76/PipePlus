package ml.pkom.pipeplus.guis;

import ml.pkom.mcpitanlibarch.api.client.registry.ArchRegistryClient;

public class PipePlusScreens {
    public static void register() {
        ArchRegistryClient.registerScreen(PipePlusContainers.TELEPORT_PIPE_SCREEN_HANDLER, TeleportPipeSettingScreen::new);
    }
}
