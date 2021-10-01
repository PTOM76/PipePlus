package ml.pkom.pipeplus;

import ml.pkom.pipeplus.blockentities.BlockEntities;
import ml.pkom.pipeplus.blockentities.PipeItemsTeleportEntity;
import ml.pkom.pipeplus.blocks.Blocks;
import ml.pkom.pipeplus.guis.PipePlusContainers;
import ml.pkom.pipeplus.guis.PipePlusScreens;
import ml.pkom.pipeplus.items.Items;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedHashMap;

public class PipePlus implements ModInitializer {

    public static final String MOD_ID = "pipeplus";
    public static final String MOD_NAME = "PipePlus";
    public static final String VERSION = "0.3.2";
    public static PipePlus instance;
    private static Logger LOGGER = LogManager.getLogger();

    public static final ItemGroup PIPEPLUS_GROUP = FabricItemGroupBuilder.build(
            id("all"),
            () -> new ItemStack(Items.COPPER_PIPE));

    public void onInitialize() {
        log(Level.INFO, "Initializing");
        instance = this;

        BlockEntities.registerInit();
        Blocks.registerInit();
        Items.registerInit();
        PipePlusContainers.load();
        ServerNetwork.init();
        ServerLifecycleEvents.SERVER_STOPPED.register((server -> {
            TeleportManager.instance.reset();
            PipeItemsTeleportEntity.tileMap = new LinkedHashMap<>();
        }));
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "[" + MOD_NAME + "] " + message);
    }

    public static Identifier id(String id) {
        return new Identifier(MOD_ID, id);
    }

    public static Identifier id(String id, boolean bool) {
        if (bool) return new Identifier(MOD_ID, id);
        return new Identifier(id);
    }

    public static String pos2str(BlockPos pos) {
        return pos.getX() + "l" + pos.getY() + "l" + pos.getZ();

    }

}
