package ml.pkom.pipeplus;

import ml.pkom.pipeplus.blockentities.BlockEntities;
import ml.pkom.pipeplus.blocks.Blocks;
import ml.pkom.pipeplus.items.Items;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PipePlus implements ModInitializer {

    public static final String MOD_ID = "pipeplus";
    public static final String MOD_NAME = "PipePlus";
    public static final String VERSION = "1.0.0";
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

}
