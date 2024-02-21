package net.pitan76.pipeplus.guis;

import net.pitan76.mcpitanlib.api.client.registry.CompatRegistryClient;

public class PipePlusScreens {
    public static void register() {
        CompatRegistryClient.registerScreen(PipePlusContainers.TELEPORT_PIPE_SCREEN_HANDLER, TeleportPipeSettingScreen::new);
    }
}
