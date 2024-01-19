package ml.pkom.pipeplus;

import ml.pkom.mcpitanlibarch.api.network.ClientNetworking;
import ml.pkom.mcpitanlibarch.api.network.PacketByteUtil;
import ml.pkom.mcpitanlibarch.api.network.ServerNetworking;
import ml.pkom.pipeplus.guis.TeleportPipeSettingHandler;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

import java.util.UUID;

public class ServerNetwork {

    public static Identifier id = PipePlus.id("network");

    public static void init() {
        ServerNetworking.registerReceiver(id, ((server, player, buf) -> {
            NbtCompound nbt = PacketByteUtil.readNbt(buf);

            if(nbt.contains("teleport_pipe.frequency")) {
                if(!(player.currentScreenHandler instanceof TeleportPipeSettingHandler gui)) {
                    return;
                }

                gui.tile.frequency = nbt.getInt("teleport_pipe.frequency");
            }

            if(nbt.contains("teleport_pipe.mode")) {
                if(!(player.currentScreenHandler instanceof TeleportPipeSettingHandler gui)) {
                    return;
                }

                gui.tile.pipeModeInt = nbt.getInt("teleport_pipe.mode");
            }

            if(nbt.contains("teleport_pipe.is_public")) {
                if(!(player.currentScreenHandler instanceof TeleportPipeSettingHandler gui)) {
                    return;
                }

                gui.tile.modeIsPublic = nbt.getBoolean("teleport_pipe.is_public");
            }
        }));
    }

    // とりあえずTagで管理する
    public static void send(NbtCompound tag) {
        PacketByteBuf buf = PacketByteUtil.create();
        buf.writeNbt(tag);
        ClientNetworking.send(id, buf);
    }

    public static void send(String key, String string) {
        NbtCompound tag = newTag();
        tag.putString("type", "string");
        tag.putString(key, string);
        send(tag);
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

    public static void send(String key, UUID uuid) {
        NbtCompound tag = newTag();
        tag.putString("type", "uuid");
        tag.putUuid(key, uuid);
        send(tag);
    }

    public static void send(String key, Byte b) {
        NbtCompound tag = newTag();
        tag.putString("type", "byte");
        tag.putByte(key, b);
        send(tag);
    }

    public static void send(String key, Double d) {
        NbtCompound tag = newTag();
        tag.putString("type", "double");
        tag.putDouble(key, d);
        send(tag);
    }

    public static void send(String key, Float f) {
        NbtCompound tag = newTag();
        tag.putString("type", "float");
        tag.putFloat(key, f);
        send(tag);
    }

    public static void send(String key, Short s) {
        NbtCompound tag = newTag();
        tag.putString("type", "short");
        tag.putShort(key, s);
        send(tag);
    }

    public static void send(String key, Long l) {
        NbtCompound tag = newTag();
        tag.putString("type", "long");
        tag.putLong(key, l);
        send(tag);
    }

    public static NbtCompound newTag() {
        return new NbtCompound();
    }


}
