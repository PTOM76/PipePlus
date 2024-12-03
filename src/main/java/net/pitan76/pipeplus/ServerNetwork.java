package net.pitan76.pipeplus;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.pitan76.mcpitanlib.api.entity.Player;
import net.pitan76.mcpitanlib.api.network.v2.ClientNetworking;
import net.pitan76.mcpitanlib.api.network.PacketByteUtil;
import net.pitan76.mcpitanlib.api.network.v2.ServerNetworking;
import net.pitan76.mcpitanlib.api.util.CompatIdentifier;
import net.pitan76.pipeplus.guis.TeleportPipeSettingHandler;

import java.util.UUID;

public class ServerNetwork {

    public static CompatIdentifier id = PipePlus._id("network");

    public static void init() {
        ServerNetworking.registerReceiver(id, (e -> {
            NbtCompound nbt = PacketByteUtil.readNbt(e.getBuf());
            Player player = e.getPlayer();

            if (!(player.getCurrentScreenHandler() instanceof TeleportPipeSettingHandler)) return;
            TeleportPipeSettingHandler gui = (TeleportPipeSettingHandler) player.getCurrentScreenHandler();

            if (nbt.contains("teleport_pipe.frequency"))
                gui.tile.frequency = nbt.getInt("teleport_pipe.frequency");

            if (nbt.contains("teleport_pipe.mode"))
                gui.tile.pipeModeInt = nbt.getInt("teleport_pipe.mode");

            if (nbt.contains("teleport_pipe.is_public"))
                gui.tile.modeIsPublic = nbt.getBoolean("teleport_pipe.is_public");

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
