package ml.pkom.pipeplus;

import ml.pkom.mcpitanlibarch.api.network.ClientNetworking;
import ml.pkom.mcpitanlibarch.api.network.PacketByteUtil;
import ml.pkom.mcpitanlibarch.api.network.ServerNetworking;
import ml.pkom.pipeplus.guis.TeleportPipeSettingHandler;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

// そもそももっといい方法があるが放置している
public class ServerNetwork {

    public static Identifier id = PipePlus.id("network");

    public static void init() {
        ServerNetworking.registerReceiver(id, ((server, player, buf) -> {
            NbtCompound tag = buf.readNbt();
            String type = tag.getString("type");
            if (tag.contains("teleportPipe.frequency")) {
                if (!(player.currentScreenHandler instanceof TeleportPipeSettingHandler)) return;
                TeleportPipeSettingHandler gui = (TeleportPipeSettingHandler) player.currentScreenHandler;
                TeleportManager.instance.remove(gui.tile, gui.tile.frequency);
                gui.tile.frequency = tag.getInt("teleportPipe.frequency");
                TeleportManager.instance.add(gui.tile, gui.tile.frequency);
            }
            if (tag.contains("teleportPipe.mode")) {
                if (!(player.currentScreenHandler instanceof TeleportPipeSettingHandler)) return;
                TeleportPipeSettingHandler gui = (TeleportPipeSettingHandler) player.currentScreenHandler;
                gui.tile.pipeModeInt = tag.getInt("teleportPipe.mode");
            }
            if (tag.contains("teleportPipe.isPublic")) {
                if (!(player.currentScreenHandler instanceof TeleportPipeSettingHandler)) return;
                TeleportPipeSettingHandler gui = (TeleportPipeSettingHandler) player.currentScreenHandler;
                gui.tile.modeIsPublic = tag.getBoolean("teleportPipe.isPublic");
            }
        }));
    }

    // とりあえずTagで管理する
    public static void send(NbtCompound tag) {
        PacketByteBuf buf = PacketByteUtil.create();
        buf.writeNbt(tag);
        ClientNetworking.send(id, buf);
    }

    public static void send(String key, Integer integer) {
        NbtCompound tag = newTag();
        tag.putString("type", "integer");
        tag.putInt(key, integer);
        send(tag);
    }

    public static void send(String key, Boolean bool) {
        NbtCompound tag = newTag();
        tag.putString("type", "bool");
        tag.putBoolean(key, bool);
        send(tag);
    }

    public static NbtCompound newTag() {
        return new NbtCompound();
    }


}
