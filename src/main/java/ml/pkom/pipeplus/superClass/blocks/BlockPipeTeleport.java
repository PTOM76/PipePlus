package ml.pkom.pipeplus.superClass.blocks;

import alexiil.mc.mod.pipes.pipe.PipeSpDef;
import ml.pkom.pipeplus.blockentities.PipeItemsTeleportEntity;
import ml.pkom.pipeplus.blocks.ExtendBlockPipe;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class BlockPipeTeleport extends ExtendBlockPipe {

    public BlockPipeTeleport(Settings settings, PipeSpDef pipeSpDef) {
        super(settings, pipeSpDef);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        if(!(world.getBlockEntity(pos) instanceof PipeItemsTeleportEntity blockEntity)) {
            return super.onUse(state, world, pos, player, hand, hitResult);
        }

        if(!blockEntity.canPlayerModifyPipe(player)) {
            return ActionResult.FAIL;
        }

        if (!world.isClient) {
            player.openHandledScreen(blockEntity);
        }

        return ActionResult.SUCCESS;
    }
}
