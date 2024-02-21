package net.pitan76.pipeplus.pipe;

import alexiil.mc.mod.pipes.container.SimplePipeContainerFactory;
import alexiil.mc.mod.pipes.pipe.PartSpPipe;
import alexiil.mc.mod.pipes.pipe.PipeSpBehaviour;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pitan76.mcpitanlib.api.util.TextUtil;
import net.pitan76.pipeplus.TeleportManager;
import net.pitan76.pipeplus.TeleportPipeType;
import net.pitan76.pipeplus.guis.TeleportPipeSettingHandler;
import net.pitan76.pipeplus.items.PipePlusItems;
import net.pitan76.pipeplus.pipeflow.TeleportPipeFlow;
import net.pitan76.pipeplus.teleport.IPipeTeleport;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class PipeSpBehaviourTeleport extends PipeSpBehaviour implements IPipeTeleport, ExtendedScreenHandlerFactory {
    public UUID pipeUUID = UUID.randomUUID();
    public UUID owner = UUID.fromString("00000000-0000-0000-0000-000000000000");
    public String ownerName = "";
    public Boolean modeIsPublic = false;
    public Integer pipeModeInt = 3; // 0=Send Only, 1=Receive Only, 2=Send & Receive 3=Disabled
    public Integer frequency = 0;

    @Override
    public ActionResult onUse(PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (owner.equals(UUID.fromString("00000000-0000-0000-0000-000000000000")))
            setOwnerNameAndUUID(player.getUuid());

        if (!canPlayerModifyPipe(player.getUuid()))
            return ActionResult.FAIL;

        if (!player.getWorld().isClient) {
            player.openHandledScreen(new SimplePipeContainerFactory(
                    PipePlusItems.PIPE_ITEMS_TELEPORT.getName(),
                    (syncId, inv, player1) -> new TeleportPipeSettingHandler(syncId, inv, this),
                    (player1, buf) -> buf.writeBlockPos(pipe.getPipePos())
            ));
        }

        return ActionResult.SUCCESS;
    }

    public PipeSpBehaviourTeleport(PartSpPipe pipe) {
        super(pipe);
        TeleportManager.instance.addPipe(this);
    }

    @Override
    public NbtCompound toNbt() {
        NbtCompound nbt = super.toNbt();
        putNbt(nbt);
        return nbt;
    }

    @Override
    public void fromNbt(NbtCompound nbt) {
        super.fromNbt(nbt);
        loadNbt(nbt);
        TeleportManager.instance.addPipe(this);
    }

    public void putNbt(NbtCompound nbt) {
        nbt.putUuid("pipe_uuid", pipeUUID);
        nbt.putUuid("owner", owner);
        nbt.putString("owner_name", ownerName);
        nbt.putBoolean("is_public", modeIsPublic);
        nbt.putInt("pipe_mode", pipeModeInt);
        nbt.putInt("frequency", frequency);
    }

    public void loadNbt(NbtCompound nbt) {
        if (nbt.contains("pipe_uuid")) {
            pipeUUID = nbt.getUuid("pipe_uuid");
        }

        if (nbt.contains("owner")) {
            owner = nbt.getUuid("owner");
        }

        if (nbt.contains("owner_name")) {
            ownerName = nbt.getString("owner_name");
        }
        else if(getWorld().getPlayerByUuid(owner) != null) {
            ownerName = getWorld().getPlayerByUuid(owner).getName().getString();
        }

        if (nbt.contains("is_public")) {
            modeIsPublic = nbt.getBoolean("is_public");
        }

        if (nbt.contains("pipe_mode")) {
            pipeModeInt = nbt.getInt("pipe_mode");
        }

        if (nbt.contains("frequency")) {
            frequency = nbt.getInt("frequency");
        }
    }

    public World getWorld() {
        return pipe.getPipeWorld();
    }

    public BlockPos getPos() {
        return pipe.getPipePos();
    }

    // IPipeTeleportTileEntity

    @Override
    public boolean isPublic() {
        return modeIsPublic;
    }

    @Override
    public UUID getOwnerUUID() {
        return owner;
    }

    @Override
    public void setOwnerNameAndUUID(UUID uuid) {
        owner = uuid;

        if (getWorld().getPlayerByUuid(uuid) != null){
            ownerName = getWorld().getPlayerByUuid(uuid).getName().getString();
        }

        // markDirty();
    }

    public boolean canReceive()
    {
        return pipeModeInt == 1 || pipeModeInt == 2;
    }

    public boolean canSend()
    {
        return pipeModeInt == 0 || pipeModeInt == 2;
    }

    @Override
    public UUID getPipeUUID() {
        return pipeUUID;
    }

    @Override
    public Integer getFrequency() {
        return frequency;
    }

    /**
     * プレイヤーがパイプを操作できるかどうか
     * @param uuid プレイヤーのUUID
     * @return true:操作可能 false:操作不可
     */
    public boolean canPlayerModifyPipe(UUID uuid) {
        // パイプがパブリックモードの場合は誰でも操作可能
        if (modeIsPublic) return true;

        // パイプのオーナーが自分の場合は操作可能
        if (owner.equals(uuid)) return true;

        if (getWorld() == null) return false;

        // クリエイティブモードの場合は操作可能
        if (getWorld().getPlayerByUuid(uuid) != null && getWorld().getPlayerByUuid(uuid).getAbilities().creativeMode)
            return true;

        // オーナーが存在しない場合は操作可能
        if (owner.equals(UUID.fromString("00000000-0000-0000-0000-000000000000")))
            return true;

        return false;
    }

    @Override
    public TeleportPipeType getPipeType() {
        return TeleportPipeType.ITEMS;
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        NbtCompound nbt = new NbtCompound();
        putNbt(nbt);
        buf.writeBlockPos(getPos());
        //buf.writeNbt(nbt);
    }

    @Override
    public Text getDisplayName() {
        return TextUtil.empty();
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new TeleportPipeSettingHandler(syncId, inv, this);
    }

    public TeleportPipeFlow getFlow() {
        if (!(pipe.getFlow() instanceof TeleportPipeFlow))
            throw new IllegalStateException("Pipe flow is not TeleportPipeFlow!");

        return (TeleportPipeFlow) pipe.getFlow();
    }
}
