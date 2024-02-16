package net.pitan76.pipeplus.guis;

import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.pitan76.mcpitanlib.api.gui.ExtendedScreenHandlerTypeBuilder;
import net.pitan76.pipeplus.PipePlus;

import static net.pitan76.pipeplus.PipePlus.registry;

public class PipePlusContainers {
    public static final Identifier TELEPORT_PIPE = PipePlus.id("teleport_pipe");

    public static final ScreenHandlerType<TeleportPipeSettingHandler> TELEPORT_PIPE_SCREEN_HANDLER = new ExtendedScreenHandlerTypeBuilder<>(TeleportPipeSettingHandler::new).build();

    public PipePlusContainers() {

    }

    public static void load() {
        register(TELEPORT_PIPE, TELEPORT_PIPE_SCREEN_HANDLER);
    }

    private static void register(Identifier id, ScreenHandlerType<? extends ScreenHandler> type) {
        registry.registerScreenHandlerType(id, () -> type);
    }
}
