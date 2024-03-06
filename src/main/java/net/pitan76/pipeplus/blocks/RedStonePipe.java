package net.pitan76.pipeplus.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipeItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.pitan76.mcpitanlib.api.block.CompatibleBlockSettings;
import net.pitan76.mcpitanlib.api.block.CompatibleMaterial;
import net.pitan76.mcpitanlib.api.util.WorldUtil;
import net.pitan76.pipeplus.parts.PipePlusParts;

import java.util.Random;


public class RedStonePipe extends ExtendBlockPipe implements BlockPipeItem {
    public static CompatibleBlockSettings blockSettings = CompatibleBlockSettings.of(CompatibleMaterial.DECORATION);
    public static BooleanProperty POWERED;
    public boolean isPowered = false;

    static {
        blockSettings.strength(0.5F, 1.0F);
        blockSettings.sounds(BlockSoundGroup.GLASS);
        POWERED = Properties.POWERED;
    }

    public RedStonePipe(CompatibleBlockSettings settings) {
        super(settings, PipePlusParts.REDSTONE_ITEM_PIPE);
        setDefaultState(stateManager.getDefaultState().with(POWERED, false));
    }

    public void setRedStoneSignal(BlockState state, World world, BlockPos pos, boolean bool) {
        world.setBlockState(pos, state.with(POWERED, bool), 3);
        world.scheduleBlockRerenderIfNeeded(pos, state, state.with(POWERED, bool));
        isPowered = bool;
    }

    public boolean isPowered() {
        return isPowered;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient) {
            if (!(Boolean)state.get(POWERED)) {
                this.updatePoweredStatus(world, pos, state);
            }
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!oldState.isOf(state.getBlock())) {
            this.updatePoweredStatus(world, pos, state);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    @SuppressWarnings("deprecation")
    @Override
    public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return (Boolean) state.get(POWERED) ? 15 : 0;
    }

    @SuppressWarnings("deprecation")
    @Override
    public int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        if (!(Boolean) state.get(POWERED)) {
            return 0;
        } else {
            return direction == Direction.UP ? 15 : 0;
        }
    }

    public void updatePoweredStatus(World world, BlockPos pos, BlockState state) {
        WorldUtil.scheduleBlockTick(world, pos, this, 20);
        world.updateComparators(pos, this);
    }

    public static RedStonePipe newBlock() {
        return new RedStonePipe(blockSettings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(POWERED);
    }
}