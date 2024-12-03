package net.pitan76.pipeplus;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.pitan76.mcpitanlib.api.event.v0.EventRegistry;
import net.pitan76.mcpitanlib.api.item.CreativeTabBuilder;
import net.pitan76.mcpitanlib.api.registry.v2.CompatRegistryV2;
import net.pitan76.mcpitanlib.api.util.CompatIdentifier;
import net.pitan76.mcpitanlib.api.util.ItemStackUtil;
import net.pitan76.mcpitanlib.fabric.ExtendModInitializer;
import net.pitan76.pipeplus.config.PipePlusConfig;
import net.pitan76.pipeplus.guis.PipePlusContainers;
import net.pitan76.pipeplus.items.PipePlusItems;
import net.pitan76.pipeplus.parts.PipePlusParts;

public class PipePlus extends ExtendModInitializer {

    public static final String MOD_ID = "pipeplus";
    public static final String MOD_NAME = "PipePlus";
    public static PipePlus instance;

    public static final CreativeTabBuilder PIPEPLUS_GROUP = CreativeTabBuilder.create(
            _id("all")).
            setIcon(() -> ItemStackUtil.create(PipePlusItems.COPPER_PIPE));

    public static CompatRegistryV2 registry;

    public void init() {
        instance = this;
        registry = super.registry;

        registry.registerItemGroup(_id("all"), PIPEPLUS_GROUP);
        AutoConfig.register(PipePlusConfig.class, GsonConfigSerializer::new);
        PipePlusParts.init();
        PipePlusItems.init();

        PipePlusContainers.load();
        ServerNetwork.init();
        TeleportManager.register();
        
        EventRegistry.ServerLifecycle.serverStopped((server -> TeleportManager.instance.reset()));
    }

    public static CompatIdentifier _id(String id) {
        return CompatIdentifier.of(MOD_ID, id);
    }

    @Override
    public String getName() {
        return MOD_NAME;
    }

    @Override
    public String getId() {
        return MOD_ID;
    }
}
