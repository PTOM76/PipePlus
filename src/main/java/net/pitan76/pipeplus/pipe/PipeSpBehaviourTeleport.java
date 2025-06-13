package net.pitan76.pipeplus.pipe;

import alexiil.mc.mod.pipes.pipe.PartSpPipe;
import alexiil.mc.mod.pipes.pipe.PipeSpBehaviour;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pitan76.mcpitanlib.api.entity.Player;
import net.pitan76.mcpitanlib.api.event.container.factory.DisplayNameArgs;
import net.pitan76.mcpitanlib.api.event.container.factory.ExtraDataArgs;
import net.pitan76.mcpitanlib.api.gui.args.CreateMenuEvent;
import net.pitan76.mcpitanlib.api.gui.v2.ExtendedScreenHandlerFactory;
import net.pitan76.mcpitanlib.api.util.NbtUtil;
import net.pitan76.mcpitanlib.api.util.PlayerManagerUtil;
import net.pitan76.mcpitanlib.api.util.TextUtil;
import net.pitan76.pipeplus.TeleportManager;
import net.pitan76.pipeplus.TeleportPipeType;
import net.pitan76.pipeplus.guis.TeleportPipeSettingHandler;
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
    public ActionResult onUse(PlayerEntity p, BlockHitResult hit) {
        Player player = new Player(p);

        if (owner.equals(UUID.fromString("00000000-0000-0000-0000-000000000000")))
            setOwnerNameAndUUID(player.getUUID());

        if (!canPlayerModifyPipe(player.getUUID()))
            return ActionResult.FAIL;

        if (!player.isClient())
            player.openExtendedMenu(this);

        return ActionResult.SUCCESS;
    }

    public PipeSpBehaviourTeleport(PartSpPipe pipe) {
        super(pipe);
        TeleportManager.instance.addPipe(this);
    }

    @Override
    public NbtCompound toNbt(RegistryWrapper.WrapperLookup lookup) {
        NbtCompound nbt = super.toNbt(lookup);
        putNbt(nbt);
        return nbt;

    }

    @Override
    public void fromNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup lookup) {
        super.fromNbt(nbt, lookup);
        loadNbt(nbt);
        TeleportManager.instance.addPipe(this);
    }

    public void putNbt(NbtCompound nbt) {
        NbtUtil.putUuid(nbt, "pipe_uuid", pipeUUID);
        NbtUtil.putUuid(nbt, "owner", owner);
        NbtUtil.putString(nbt, "owner_name", ownerName);
        NbtUtil.putBoolean(nbt, "is_public", modeIsPublic);
        NbtUtil.putInt(nbt, "pipe_mode", pipeModeInt);
        NbtUtil.putInt(nbt, "frequency", frequency);
    }

    public void loadNbt(NbtCompound nbt) {
        if (NbtUtil.has(nbt, "pipe_uuid")) {
            pipeUUID = NbtUtil.getUuid(nbt, "pipe_uuid");
        }

        if (NbtUtil.has(nbt, "owner")) {
            owner = NbtUtil.getUuid(nbt, "owner");
        }

        if (NbtUtil.has(nbt, "owner_name")) {
            ownerName = NbtUtil.getString(nbt, "owner_name");
        } else if (PlayerManagerUtil.hasPlayerByUUID(getWorld(), owner)) {
            ownerName = PlayerManagerUtil.getPlayerByUUID(getWorld(), owner).getName();
        }

        if (NbtUtil.has(nbt, "is_public")) {
            modeIsPublic = NbtUtil.getBoolean(nbt, "is_public");
        }

        if (NbtUtil.has(nbt, "pipe_mode")) {
            pipeModeInt = NbtUtil.getInt(nbt, "pipe_mode");
        }

        if (NbtUtil.has(nbt, "frequency")) {
            frequency = NbtUtil.getInt(nbt, "frequency");
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

        if (PlayerManagerUtil.hasPlayerByUUID(getWorld(), uuid)){
            ownerName = PlayerManagerUtil.getPlayerByUUID(getWorld(), uuid).getName();
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
        if (PlayerManagerUtil.hasPlayerByUUID(getWorld(), uuid) && PlayerManagerUtil.getPlayerByUUID(getWorld(), uuid).isCreative())
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
    public void writeExtraData(ExtraDataArgs args) {
        args.writeVar(pipe.getPipePos());
    }

    @Override
    public Text getDisplayName(DisplayNameArgs args) {
        return TextUtil.empty();
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(CreateMenuEvent e) {
        return new TeleportPipeSettingHandler(e.syncId, e.playerInventory, this);
    }

    public TeleportPipeFlow getFlow() {
        if (!(pipe.getFlow() instanceof TeleportPipeFlow))
            throw new IllegalStateException("Pipe flow is not TeleportPipeFlow!");

        return (TeleportPipeFlow) pipe.getFlow();
    }
}
