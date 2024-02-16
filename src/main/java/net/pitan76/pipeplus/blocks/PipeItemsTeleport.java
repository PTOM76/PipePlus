package net.pitan76.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeItem;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;
import net.pitan76.pipeplus.blockentities.PipeItemsTeleportEntity;
import net.pitan76.pipeplus.parts.PipePlusParts;
import net.pitan76.pipeplus.superClass.blocks.BlockPipeTeleport;
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
        if(!(world.getBlockEntity(pos) instanceof PipeItemsTeleportEntity) || !(entity instanceof PlayerEntity)) return;

        PipeItemsTeleportEntity pipeTile = (PipeItemsTeleportEntity) world.getBlockEntity(pos);
        PlayerEntity player = (PlayerEntity) entity;

        UUID owner = player.getUuid();
        pipeTile.setOwnerNameAndUUID(owner);
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
