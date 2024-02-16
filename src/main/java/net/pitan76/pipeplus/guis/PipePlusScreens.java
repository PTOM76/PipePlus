package net.pitan76.pipeplus.guis;

import net.pitan76.mcpitanlib.api.client.registry.ArchRegistryClient;

public class PipePlusScreens {
    public static void register() {
        ArchRegistryClient.registerScreen(PipePlusContainers.TELEPORT_PIPE_SCREEN_HANDLER, TeleportPipeSettingScreen::new);
    }
}
