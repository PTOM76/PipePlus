package net.pitan76.pipeplus.guis;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.pitan76.pipeplus.PipePlus;

import static net.pitan76.pipeplus.PipePlus.registry;

public class PipePlusContainers {
    public static final Identifier TELEPORT_PIPE = PipePlus.id("teleport_pipe");

    public static final ExtendedScreenHandlerType<TeleportPipeSettingHandler> TELEPORT_PIPE_SCREEN_HANDLER = new ExtendedScreenHandlerType<>(TeleportPipeSettingHandler::new);

    public PipePlusContainers() {

    }

    public static void load() {
        register(TELEPORT_PIPE, TELEPORT_PIPE_SCREEN_HANDLER);
    }

    private static void register(Identifier id, ScreenHandlerType<? extends ScreenHandler> type) {
        registry.registerMenu(id, () -> type);
    }
}
