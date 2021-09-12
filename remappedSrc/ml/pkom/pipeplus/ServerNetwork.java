package ml.pkom.pipeplus;

import ml.pkom.pipeplus.guis.TeleportPipeSettingHandler;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

import java.util.UUID;

public class ServerNetwork {

    public static Identifier id = PipePlus.id("network");

    public static void init() {
        ServerPlayNetworking.registerGlobalReceiver(id, ((server, player, handler, buf, responseSender) -> {
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
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeNbt(tag);
        ClientPlayNetworking.send(id, buf);
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
