package ml.pkom.pipeplus.superClass.blocks;

import alexiil.mc.mod.pipes.blocks.BlockPipe;
import alexiil.mc.mod.pipes.pipe.PipeSpDef;
import ml.pkom.pipeplus.PipePlus;
import ml.pkom.pipeplus.blockentities.PipeItemsTeleportEntity;
import ml.pkom.pipeplus.guis.PipePlusContainers;
import ml.pkom.pipeplus.guis.TeleportPipeSettingHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class BlockPipeTeleport extends BlockPipe {

    public BlockPipeTeleport(Settings settings, PipeSpDef pipeSpDef) {
        super(settings, pipeSpDef);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof PipeItemsTeleportEntity) {

            //System.out.println(PipePlus.pos2str(pos));
            if (!PipeItemsTeleportEntity.tileMap.containsKey(PipePlus.pos2str(pos))) PipeItemsTeleportEntity.tileMap.put(PipePlus.pos2str(pos), (PipeItemsTeleportEntity) blockEntity);
            //System.out.println(PipeItemsTeleportEntity.tileMap);
            if (!PipeItemsTeleportEntity.tileMap.get(PipePlus.pos2str(pos)).canPlayerModifyPipe(player)) {
                return ActionResult.FAIL;
            }

            if (!world.isClient) {
                player.openHandledScreen(new NamedScreenHandlerFactory() {
                    @Override
                    public Text getDisplayName() {
                        return null;
                    }

                    @Nullable
                    @Override
                    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
                        return new TeleportPipeSettingHandler(syncId, player, (PipeItemsTeleportEntity) blockEntity);
                    }
                });
            }
            return ActionResult.SUCCESS;
        }

        return super.onUse(state, world, pos, player, hand, hitResult);
    }
}
