package ml.pkom.pipeplus;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import ml.pkom.mcpitanlibarch.api.item.CreativeTabBuilder;
import ml.pkom.mcpitanlibarch.api.registry.ArchRegistry;
import ml.pkom.pipeplus.config.PipePlusConfig;
import ml.pkom.pipeplus.items.PipePlusItems;
import ml.pkom.pipeplus.parts.PipePlusParts;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PipePlus implements ModInitializer {

    public static final String MOD_ID = "pipeplus";
    public static final String MOD_NAME = "PipePlus";
    public static PipePlus instance;
    private static final Logger LOGGER = LogManager.getLogger();

    public static final ItemGroup PIPEPLUS_GROUP = CreativeTabBuilder.create(
            id("all")).
            setIcon(PipePlusParts.COPPER_ITEM_PIPE::getPickStack).
            build();

    public static ArchRegistry registry = ArchRegistry.createRegistry(MOD_ID);

    public void onInitialize() {
        log(Level.INFO, "Initializing");
        instance = this;

        registry.registerItemGroup(id("all"), () -> PIPEPLUS_GROUP);
        AutoConfig.register(PipePlusConfig.class, GsonConfigSerializer::new);
        PipePlusParts.init();
        PipePlusItems.init();

        registry.allRegister();
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
