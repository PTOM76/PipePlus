package ml.pkom.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeItem;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import ml.pkom.pipeplus.TeleportManager;
import ml.pkom.pipeplus.blockentities.PipeItemsTeleportEntity;
import ml.pkom.pipeplus.parts.PipePlusParts;
import ml.pkom.pipeplus.superClass.blocks.BlockPipeTeleport;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.UUID;

public class PipeItemsTeleport extends BlockPipeTeleport implements BlockPipeItem {
    public static FabricBlockSettings blockSettings = FabricBlockSettings.of(Material.DECORATION);

    //public UUID latestOwner;

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);
    }

    public PipeItemsTeleport(Settings settings) {
        super(settings, PipePlusParts.TELEPORT_ITEM_PIPE);
    }


    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
        super.onPlaced(world, pos, state, entity, stack);

        if(!(world.getBlockEntity(pos) instanceof PipeItemsTeleportEntity pipeTile)) {
            return;
        }

        if(!(entity instanceof PlayerEntity player)) {
            return;
        }

        UUID owner = player.getUuid();
        pipeTile.setOwnerNameAndUUID(owner);
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBreak(world, pos, state, player);

        if(!(world.getBlockEntity(pos) instanceof PipeItemsTeleportEntity pipeTile)) {
            return;
        }

        pipeTile.getFlow().lock();

        if(pipeTile.canPlayerModifyPipe(player)){
            TeleportManager.instance.removePipe(pipeTile);
        }

        pipeTile.getFlow().unlock();

        world.setBlockState(pos, state);
    }

    @Override
    public TilePipe createBlockEntity(TileCreateEvent event) {
        return new PipeItemsTeleportEntity(event);
    }

    public static Settings getSettings() {
        return blockSettings;
    }

    public static PipeItemsTeleport newBlock() {
        return new PipeItemsTeleport(getSettings());
    }
}
