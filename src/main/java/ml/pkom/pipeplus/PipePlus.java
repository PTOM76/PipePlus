package ml.pkom.pipeplus;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import ml.pkom.mcpitanlibarch.api.item.CreativeTabBuilder;
import ml.pkom.mcpitanlibarch.api.registry.ArchRegistry;
import ml.pkom.pipeplus.blockentities.BlockEntities;
import ml.pkom.pipeplus.blockentities.PipeItemsTeleportEntity;
import ml.pkom.pipeplus.blocks.Blocks;
import ml.pkom.pipeplus.config.PipePlusConfig;
import ml.pkom.pipeplus.guis.PipePlusContainers;
import ml.pkom.pipeplus.items.Items;
import ml.pkom.pipeplus.parts.PipePlusParts;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedHashMap;

public class PipePlus implements ModInitializer {

    public static final String MOD_ID = "pipeplus";
    public static final String MOD_NAME = "PipePlus";
    public static PipePlus instance;
    private static Logger LOGGER = LogManager.getLogger();

    public static final ItemGroup PIPEPLUS_GROUP = new CreativeTabBuilder(
            id("all")).
            setIcon(() -> new ItemStack(Items.COPPER_PIPE)).
            build();

    public static ArchRegistry registry = ArchRegistry.createRegistry(MOD_ID);

    public void onInitialize() {
        log(Level.INFO, "Initializing");
        instance = this;

        AutoConfig.register(PipePlusConfig.class, GsonConfigSerializer::new);
        PipePlusParts.init();
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

    public static String pos2str(BlockPos pos) {
        return pos.getX() + "l" + pos.getY() + "l" + pos.getZ();

    }

}
