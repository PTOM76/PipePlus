package ml.pkom.pipeplus.pipe;

import alexiil.mc.mod.pipes.pipe.PartSpPipe;
import alexiil.mc.mod.pipes.pipe.PipeSpBehaviour;
import alexiil.mc.mod.pipes.pipe.TravellingItem;
import ml.pkom.pipeplus.blockentities.ObsidianPipeEntity;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

import java.util.List;
import java.util.stream.Collectors;

public class PipeSpBehaviourObsidian extends PipeSpBehaviour {
    private static final VoxelShape INPUT_AREA_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape REDSTONE_SIGNAL_INPUT_AREA_SHAPE = Block.createCuboidShape(-16.0D, -16.0D, -16.0D, 32.0D, 32.0D, 32.0D);

    public VoxelShape getInputAreaShape() {
        return INPUT_AREA_SHAPE;
    }

    public VoxelShape getRedstoneSignalInputAreaShape() {
        return REDSTONE_SIGNAL_INPUT_AREA_SHAPE;
    }

    public PipeSpBehaviourObsidian(PartSpPipe pipe) {
        super(pipe);
    }

    public double getX() {
        return (double)pipe.getPipePos().getX() + 0.5D;
    }

    public double getY() {
        return (double)pipe.getPipePos().getY() + 0.5D;
    }

    public double getZ() {
        return (double)pipe.getPipePos().getZ() + 0.5D;
    }

    public void tick() {
        super.tick();
        if (pipe.getPipeWorld() != null && !pipe.getPipeWorld().isClient) {
            extract();
        }
    }

    public boolean extract() {
        List<ItemEntity> itemsList = getInputItemEntities();
        if (itemsList.isEmpty())
            return false;
        if (isNotConnected())
            return false;
        NbtCompound nbt = new NbtCompound();
        NbtList tagList = new NbtList();
        long tickNow = pipe.getWorldTime();
        for (ItemEntity itemEntity : itemsList) {
            TravellingItem item = new TravellingItem(itemEntity.getStack());
            tagList.add(item.writeToNbt(tickNow));
            itemEntity.remove(Entity.RemovalReason.KILLED);
        }
        nbt.put("items", tagList);
        pipe.getFlow().fromTag(nbt);
        return true;
    }

    public boolean isNotConnected() {
        if(pipe.isConnected(Direction.UP)) return false;
        if(pipe.isConnected(Direction.DOWN)) return false;
        if(pipe.isConnected(Direction.NORTH)) return false;
        if(pipe.isConnected(Direction.SOUTH)) return false;
        if(pipe.isConnected(Direction.EAST)) return false;
        if(pipe.isConnected(Direction.WEST)) return false;
        return true;
    }

    public List<ItemEntity> getInputItemEntities() {
        VoxelShape voxelShape;
        if (pipe.getPipeWorld().isReceivingRedstonePower(pipe.getPipePos())) {
            voxelShape = getRedstoneSignalInputAreaShape();
        } else {
            voxelShape = getInputAreaShape();
        }
        return voxelShape.getBoundingBoxes().stream().flatMap((box) -> pipe.getPipeWorld().getEntitiesByClass(ItemEntity.class, box.offset(getX() - 0.5D, getY() - 0.5D, getZ() - 0.5D), EntityPredicates.VALID_ENTITY).stream()).collect(Collectors.toList());
    }
}
