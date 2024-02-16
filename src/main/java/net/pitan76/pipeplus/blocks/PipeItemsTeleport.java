package net.pitan76.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeItem;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pitan76.mcpitanlib.api.block.CompatibleBlockSettings;
import net.pitan76.mcpitanlib.api.block.CompatibleMaterial;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;
import net.pitan76.pipeplus.blockentities.PipeItemsTeleportEntity;
import net.pitan76.pipeplus.parts.PipePlusParts;
import net.pitan76.pipeplus.superClass.blocks.BlockPipeTeleport;

import java.util.UUID;

public class PipeItemsTeleport extends BlockPipeTeleport implements BlockPipeItem {
    public static CompatibleBlockSettings blockSettings = CompatibleBlockSettings.of(CompatibleMaterial.DECORATION);

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);
    }

    public PipeItemsTeleport(CompatibleBlockSettings settings) {
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

    public static PipeItemsTeleport newBlock() {
        return new PipeItemsTeleport(blockSettings);
    }
}
