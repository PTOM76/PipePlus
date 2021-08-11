package ml.pkom.pipeplus.blockentities;

import alexiil.mc.mod.pipes.blocks.PipeFlowItem;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import alexiil.mc.mod.pipes.blocks.TravellingItem;
import ml.pkom.pipeplus.blocks.Blocks;
import ml.pkom.pipeplus.pipeflow.EmeraldPipeFlow;
import net.minecraft.block.Block;
import net.minecraft.entity.ItemEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

import java.util.List;
import java.util.stream.Collectors;

public class EmeraldPipeEntity extends TilePipe {

    public EmeraldPipeEntity() {
        super(BlockEntities.EMERALD_PIPE_ENTITY, Blocks.EMERALD_PIPE, EmeraldPipeFlow::new);
    }
}
