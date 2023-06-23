package ml.pkom.pipeplus.pipe;

import alexiil.mc.mod.pipes.pipe.PartSpPipe;
import alexiil.mc.mod.pipes.pipe.PipeSpBehaviour;
import ml.pkom.mcpitanlibarch.api.entity.Player;
import ml.pkom.pipeplus.PipePlus;
import ml.pkom.pipeplus.blockentities.PipeItemsTeleportEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PipeSpBehaviourTeleport extends PipeSpBehaviour {
    public PipeSpBehaviourTeleport(PartSpPipe pipe) {
        super(pipe);
    }

    @Override
    public ActionResult onUse(PlayerEntity playerEntity, Hand hand, BlockHitResult hit) {
        Player player = new Player(playerEntity);
        World world = player.getWorld();
        BlockPos pos = hit.getBlockPos();

        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof PipeItemsTeleportEntity) {

            //System.out.println(PipePlus.pos2str(pos));
            if (!PipeItemsTeleportEntity.tileMap.containsKey(PipePlus.pos2str(pos))) PipeItemsTeleportEntity.tileMap.put(PipePlus.pos2str(pos), (PipeItemsTeleportEntity) blockEntity);
            //System.out.println(PipeItemsTeleportEntity.tileMap);
            if (!PipeItemsTeleportEntity.tileMap.get(PipePlus.pos2str(pos)).canPlayerModifyPipe(player.getPlayerEntity())) {
                return ActionResult.FAIL;
            }

            if (!world.isClient) {
                player.openGuiScreen((PipeItemsTeleportEntity) blockEntity);
            }
            return ActionResult.SUCCESS;
        }

        return super.onUse(player.getPlayerEntity(), hand, hit);
    }
}
