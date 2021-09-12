package ml.pkom.pipeplus.items;

import ml.pkom.pipeplus.PipePlus;
import ml.pkom.pipeplus.blockentities.PipeItemsTeleportEntity;
import ml.pkom.pipeplus.blocks.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import org.apache.logging.log4j.Level;

public class DebugItem extends Item {
    public static Settings itemSettings = new Settings();

    static {
        itemSettings.group(PipePlus.PIPEPLUS_GROUP);
    }

    public DebugItem(Settings settings) {
        super(settings);
    }

    public static Settings getSettings() {
        return itemSettings;
    }

    public static Item newItem() {
        return new DebugItem(getSettings());
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockEntity blockEntity = context.getWorld().getBlockEntity(context.getBlockPos());
        boolean hasBlockEntity = (blockEntity != null);

        if (context.getWorld().isClient()) {
            PipePlus.log(Level.INFO, "Client: [hasBlockEntity: " + hasBlockEntity + "]");
            if (hasBlockEntity && blockEntity instanceof PipeItemsTeleportEntity) {
                PipeItemsTeleportEntity pipe = (PipeItemsTeleportEntity) blockEntity;
                PipePlus.log(Level.INFO, "Client: [frequency: " + pipe.frequency + "]");
                PipePlus.log(Level.INFO, "Client: [modeIsPublic: " + pipe.modeIsPublic + "]");
                PipePlus.log(Level.INFO, "Client: [pipeModeInt: " + pipe.pipeModeInt + "]");
                PipePlus.log(Level.INFO, "Client: [ownerName: " + pipe.ownerName + "]");
            }
            return ActionResult.SUCCESS;
        }

        PipePlus.log(Level.INFO, "Server: [hasBlockEntity: " + hasBlockEntity + "]");
        if (hasBlockEntity && blockEntity instanceof PipeItemsTeleportEntity) {
            PipeItemsTeleportEntity pipe = (PipeItemsTeleportEntity) blockEntity;
            PipePlus.log(Level.INFO, "Server: [frequency: " + pipe.frequency + "]");
            PipePlus.log(Level.INFO, "Server: [modeIsPublic: " + pipe.modeIsPublic + "]");
            PipePlus.log(Level.INFO, "Server: [pipeModeInt: " + pipe.pipeModeInt + "]");
            PipePlus.log(Level.INFO, "Server: [ownerName: " + pipe.ownerName + "]");
        }
        return ActionResult.SUCCESS;
    }
}
