package ml.pkom.pipeplus.blockentities;

import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import ml.pkom.mcpitanlibarch.api.util.TextUtil;
import ml.pkom.pipeplus.PipePlus;
import ml.pkom.pipeplus.TeleportManager;
import ml.pkom.pipeplus.TeleportPipeType;
import ml.pkom.pipeplus.blocks.Blocks;
import ml.pkom.pipeplus.guis.TeleportPipeSettingHandler;
import ml.pkom.pipeplus.pipeflow.TeleportPipeFlow;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class PipeItemsTeleportEntity extends ExtendTilePipe implements IPipeTeleportTileEntity, ExtendedScreenHandlerFactory {
    public UUID owner = null;
    public String ownerName = null;
    public Boolean modeIsPublic = null;
    public Integer pipeModeInt = null; // 0=Send Only, 1=Receive Only, 2=Send & Receive 3=Disabled
    public Integer frequency = null;
    //public PipeSpFlowItem iFlow = null;

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

    public static PipeItemsTeleportEntity getTilePipe(World world, BlockPos pos) {
        if (world.getBlockEntity(pos) == null) return null;
        if (!(world.getBlockEntity(pos) instanceof PipeItemsTeleportEntity)) return null;
        return (PipeItemsTeleportEntity) world.getBlockEntity(pos);
    }

    public static PipeItemsTeleportEntity getTilePipe(BlockPos pos) {
        if (!tileMap.containsKey(PipePlus.pos2str(pos))) return null;
        return tileMap.get(PipePlus.pos2str(pos));
    }

    @Override
    public void setOwnerNameAndUUID(UUID uuid) {
        owner = uuid;
        if (getWorld().getPlayerByUuid(uuid) != null) ownerName = getWorld().getPlayerByUuid(uuid).getName().getString();
        markDirty();
    }

    public boolean canReceive()
    {
        if (pipeModeInt == 0 || pipeModeInt == 3) {
            return false;
        }
        return true;
    }

    public boolean canSend()
    {
        if (pipeModeInt == 1 || pipeModeInt == 3) {
            return false;
        }
        return true;
    }

    @Override
    public Integer getFrequency() {
        return frequency;
    }

    public boolean canPlayerModifyPipe(PlayerEntity player)
    {
        if (owner == null ) return true;
        if(modeIsPublic || owner.equals(player.getUuid()) || player.getAbilities().creativeMode || owner.equals(UUID.fromString("00000000-0000-0000-0000-000000000000")))
            return true;
        return false;
    }

    public static Map<String, PipeItemsTeleportEntity> tileMap = new LinkedHashMap<>();

    @Override
    public void tick() {
        super.tick();
    }

    public PipeItemsTeleportEntity(TileCreateEvent event) {
        super(BlockEntities.PIPE_ITEMS_TELEPORT_ENTITY, event, Blocks.PIPE_ITEMS_TELEPORT, TeleportPipeFlow::new);
        //iFlow = (PipeSpFlowItem) getFlow();
        /*if (owner == null) owner = ((PipeItemsTeleport) pipeBlock).latestOwner;

        if (ownerName == null) {
            try {
                ownerName = getWorld().getPlayerByUuid(owner).getName().getString();
            } catch (NullPointerException e) {
            }
        }
         */
        if (modeIsPublic == null) modeIsPublic = false;
        if (pipeModeInt == null) pipeModeInt = 0;
        if (frequency == null) frequency = 0;
        TeleportManager.instance.add(this, frequency);
    }

    @Override
    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);
        //debug();
        //PipePlus.log(Level.INFO, "ReadTeleportPipeNBT");
        if (!tileMap.containsKey(PipePlus.pos2str(getPos()))) {
            tileMap.put(PipePlus.pos2str(getPos()), this);
        }
        PipeItemsTeleportEntity tile = tileMap.get(PipePlus.pos2str(getPos()));
        try {
            tile.owner = tag.getUuid("owner");
        } catch (NullPointerException e) {
            tile.owner = UUID.fromString("00000000-0000-0000-0000-000000000000");
        }

        try {
            tile.ownerName = getWorld().getPlayerByUuid(tile.owner).getName().getString();
        } catch (NullPointerException e) {
            tile.ownerName = tag.getString("ownerName");
        }
        tile.modeIsPublic = tag.getBoolean("isPublic");
        tile.pipeModeInt = tag.getInt("modeInt");
        tile.frequency = tag.getInt("frequency");
        TeleportManager.instance.add(tile, tile.frequency);

        //debug();
    }

    @Override
    public void writeNbt(NbtCompound tag) {
        super.writeNbt(tag);
        PipeItemsTeleportEntity tile = tileMap.get(PipePlus.pos2str(getPos()));
        try {
            tag.putUuid("owner", tile.owner);
        } catch (NullPointerException e) {
            tag.putUuid("owner", UUID.fromString("00000000-0000-0000-0000-000000000000"));
        }
        if (tile.ownerName != null)
            tag.putString("ownerName", tile.ownerName);
        if (tile.modeIsPublic != null)
            tag.putBoolean("isPublic", tile.modeIsPublic);
        if (tile.pipeModeInt != null)
            tag.putInt("modeInt", tile.pipeModeInt);
        if (tile.frequency != null)
            tag.putInt("frequency", tile.frequency);
        //debug();
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
        buf.writeBlockPos(pos);
    }

    @Override
    public Text getDisplayName() {
        return TextUtil.empty();
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeBlockPos(pos);
        return new TeleportPipeSettingHandler(syncId, inv, this);
    }
}