package ml.pkom.pipeplus.blockentities;

import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import ml.pkom.mcpitanlibarch.api.util.TextUtil;
import ml.pkom.pipeplus.TeleportManager;
import ml.pkom.pipeplus.TeleportPipeType;
import ml.pkom.pipeplus.blocks.Blocks;
import ml.pkom.pipeplus.guis.TeleportPipeSettingHandler;
import ml.pkom.pipeplus.pipeflow.TeleportPipeFlow;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class PipeItemsTeleportEntity extends ExtendTilePipe implements IPipeTeleportTileEntity, ExtendedScreenHandlerFactory {
    public UUID pipeUUID = UUID.randomUUID();
    public UUID owner = UUID.fromString("00000000-0000-0000-0000-000000000000");
    public String ownerName = "";
    public Boolean modeIsPublic = false;
    public Integer pipeModeInt = 3; // 0=Send Only, 1=Receive Only, 2=Send & Receive 3=Disabled
    public Integer frequency = 0;

    public PipeItemsTeleportEntity(TileCreateEvent event) {
        super(BlockEntities.PIPE_ITEMS_TELEPORT_ENTITY, event, Blocks.PIPE_ITEMS_TELEPORT, TeleportPipeFlow::new);
    }

    @Override
    public void setWorld(World world) {
        super.setWorld(world);

        if(!world.isClient) {
            TeleportManager.instance.addPipe(this);
        }
    }

    @Override
    public boolean isPublic() {
        return modeIsPublic;
    }

    @Override
    public UUID getOwnerUUID() {
        return owner;
    }

    @Override
    public TeleportPipeFlow getFlow() {
        return (TeleportPipeFlow) super.getFlow();
    }

    @Override
    public void setOwnerNameAndUUID(UUID uuid) {
        owner = uuid;

        if (getWorld().getPlayerByUuid(uuid) != null){
            ownerName = getWorld().getPlayerByUuid(uuid).getName().getString();
        }

        markDirty();
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

    public boolean canPlayerModifyPipe(UUID uuid)
    {
        if(modeIsPublic) {
            return true;
        }

        if(owner.equals(uuid)) {
            return true;
        }

        if(world.getPlayerByUuid(uuid) != null) {
            if (world.getPlayerByUuid(uuid).getAbilities().creativeMode) {
                return true;
            }
        }

        if(owner.equals(UUID.fromString("00000000-0000-0000-0000-000000000000"))) {
            return true;
        }

        return false;
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);

        loadNBT(tag);
    }


    @Override
    public void writeNbt(NbtCompound tag) {
        putNBT(tag);

        super.writeNbt(tag);
    }

    @Override
    public void readPacket(NbtCompound tag) {
        super.readPacket(tag);

        loadNBT(tag);
    }

    @Override
    public NbtCompound toClientTag(NbtCompound tag) {
        putNBT(tag);

        return super.toClientTag(tag);
    }

    private void putNBT(NbtCompound nbt) {
        nbt.putUuid("pipe_uuid", pipeUUID);
        nbt.putUuid("owner", owner);
        nbt.putString("owner_name", ownerName);
        nbt.putBoolean("is_public", modeIsPublic);
        nbt.putInt("pipe_mode", pipeModeInt);
        nbt.putInt("frequency", frequency);
    }

    public void loadNBT(NbtCompound nbt) {
        if(nbt.contains("pipe_uuid")) {
            pipeUUID = nbt.getUuid("pipe_uuid");
        }

        if(nbt.contains("owner")) {
            owner = nbt.getUuid("owner");
        }

        if(nbt.contains("owner_name")) {
            ownerName = nbt.getString("owner_name");
        }
        else if(getWorld().getPlayerByUuid(owner) != null) {
            ownerName = getWorld().getPlayerByUuid(owner).getName().getString();
        }

        if(nbt.contains("is_public")) {
            modeIsPublic = nbt.getBoolean("is_public");
        }

        if(nbt.contains("pipe_mode")) {
            pipeModeInt = nbt.getInt("pipe_mode");
        }

        if(nbt.contains("frequency")) {
            frequency = nbt.getInt("frequency");
        }
    }

    public void debug() {
        System.out.println("owner: " + owner + ", isPublic: " + modeIsPublic + ", modeInt: " + pipeModeInt + ", frequency: " + frequency);
    }

    @Override
    public TeleportPipeType getPipeType() {
        return TeleportPipeType.ITEMS;
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        NbtCompound nbt = new NbtCompound();

        putNBT(nbt);

        buf.writeBlockPos(pos);
        buf.writeNbt(nbt);
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
}