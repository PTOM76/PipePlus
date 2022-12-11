package ml.pkom.pipeplus.guis;

import ml.pkom.pipeplus.PipePlus;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import static ml.pkom.pipeplus.PipePlus.registry;

public class PipePlusContainers {
    public static final Identifier TELEPORT_PIPE = PipePlus.id("teleport_pipe");

    public static final ScreenHandlerType<TeleportPipeSettingHandler> TELEPORT_PIPE_SCREEN_HANDLER = new ExtendedScreenHandlerType<>(TeleportPipeSettingHandler.FACTORY);

    public PipePlusContainers() {

    }

    public static void load() {
        register(TELEPORT_PIPE, TELEPORT_PIPE_SCREEN_HANDLER);
    }

    private static void register(Identifier id, ScreenHandlerType<? extends ScreenHandler> type) {
        registry.registerScreenHandlerType(id, () -> type);
    }
}
