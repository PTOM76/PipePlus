package ml.pkom.pipeplus.guis;

import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class PipePlusScreens {
    public static void load() {
        register(PipePlusContainers.TELEPORT_PIPE_SCREEN_HANDLER, TeleportPipeSettingScreen.FACTORY);
    }

    private static <C extends ScreenHandler> void register(ScreenHandlerType<? extends C> type, HandledScreens.Provider<C, ?> factory) {
        HandledScreens.register(type, factory);
    }
}
