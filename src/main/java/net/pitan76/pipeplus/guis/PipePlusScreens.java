package net.pitan76.pipeplus.guis;

import net.pitan76.mcpitanlib.api.client.registry.CompatRegistryClient;
import net.pitan76.pipeplus.PipePlus;

public class PipePlusScreens {
    public static void register() {
        CompatRegistryClient.registerScreen(PipePlus.MOD_ID, PipePlusContainers.TELEPORT_PIPE_SCREEN_HANDLER, TeleportPipeSettingScreen::new);
    }
}
