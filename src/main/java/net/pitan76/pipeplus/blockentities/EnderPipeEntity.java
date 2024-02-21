package net.pitan76.pipeplus.blockentities;

import alexiil.mc.mod.pipes.blocks.PipeFlowItem;
import alexiil.mc.mod.pipes.blocks.TravellingItem;
import net.minecraft.block.Block;
import net.minecraft.entity.ItemEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.util.shape.VoxelShape;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;
import net.pitan76.pipeplus.blocks.Blocks;
import net.pitan76.pipeplus.util.PipeUtil;

import java.util.List;
import java.util.stream.Collectors;

public class EnderPipeEntity extends ExtendTilePipe {
    private static VoxelShape INPUT_AREA_SHAPE = Block.createCuboidShape(-48.0D, -48.0D, -48.0D, 64.0D, 64.0D, 64.0D);
    private static VoxelShape REDSTONE_SIGNAL_INPUT_AREA_SHAPE = Block.createCuboidShape(-80.0D, -80.0D, -80.0D, 96.0D, 96.0D, 96.0D);

    public EnderPipeEntity(TileCreateEvent event) {
        super(BlockEntities.ENDER_PIPE_ENTITY, event, Blocks.ENDER_PIPE, PipeFlowItem::new);
    }

    public double getX() {
        return (double)this.pos.getX() + 0.5D;
    }

    public double getY() {
        return (double)this.pos.getY() + 0.5D;
    }

    public double getZ() {
        return (double)this.pos.getZ() + 0.5D;
    }

    public void tick() {
        super.tick();
        if (world != null && !world.isClient) {
            extract(this);
        }
    }

    public static boolean extract(EnderPipeEntity entity) {
        List<ItemEntity> itemsList = getInputItemEntities(entity);

        if (itemsList.isEmpty()) {
            return false;
        }

        if (PipeUtil.isNotConnectedPipe(entity)) {
            return false;
        }

        NbtCompound nbt = new NbtCompound();
        NbtList tagList = new NbtList();
        long tickNow = entity.getWorldTime();

        for (ItemEntity itemEntity : itemsList) {
            TravellingItem item = new TravellingItem(itemEntity.getStack());
            tagList.add(item.writeToNbt(tickNow));
            itemEntity.remove();
        }

        nbt.put("items", tagList);
        entity.flow.fromTag(nbt);
        return true;
    }

    public static List<ItemEntity> getInputItemEntities(EnderPipeEntity entity) {
        VoxelShape voxelShape;
        if (entity.world.isReceivingRedstonePower(entity.getPos())) {
            voxelShape = REDSTONE_SIGNAL_INPUT_AREA_SHAPE;
        } else {
            voxelShape = INPUT_AREA_SHAPE;
        }
        return voxelShape.getBoundingBoxes().stream().flatMap((box) -> {
            return entity.getWorld().getEntitiesByClass(ItemEntity.class, box.offset(entity.getX() - 0.5D, entity.getY() - 0.5D, entity.getZ() - 0.5D), EntityPredicates.VALID_ENTITY).stream();
        }).collect(Collectors.toList());
    }

}
