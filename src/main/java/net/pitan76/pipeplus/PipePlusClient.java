package net.pitan76.pipeplus;

import net.fabricmc.api.ClientModInitializer;
import net.pitan76.pipeplus.guis.PipePlusScreens;

public class PipePlusClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        PipePlusScreens.register();
    }
}