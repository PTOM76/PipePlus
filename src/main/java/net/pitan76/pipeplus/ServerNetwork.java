package net.pitan76.pipeplus;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.pitan76.mcpitanlib.api.entity.Player;
import net.pitan76.mcpitanlib.api.network.v2.ClientNetworking;
import net.pitan76.mcpitanlib.api.network.PacketByteUtil;
import net.pitan76.mcpitanlib.api.network.v2.ServerNetworking;
import net.pitan76.mcpitanlib.api.util.CompatIdentifier;
import net.pitan76.mcpitanlib.api.util.NbtUtil;
import net.pitan76.pipeplus.guis.TeleportPipeSettingHandler;

import java.util.UUID;

public class ServerNetwork {

    public static CompatIdentifier id = PipePlus._id("network");

    public static void init() {
        ServerNetworking.registerReceiver(id, (e -> {
            NbtCompound nbt = PacketByteUtil.readNbt(e.buf);

            Player player = e.player;
            if (!(player.getCurrentScreenHandler() instanceof TeleportPipeSettingHandler)) return;
            TeleportPipeSettingHandler gui = (TeleportPipeSettingHandler) player.getCurrentScreenHandler();

            if (NbtUtil.has(nbt, "teleport_pipe.frequency"))
                gui.behaviour.frequency = NbtUtil.getInt(nbt, "teleport_pipe.frequency");

            if (NbtUtil.has(nbt, "teleport_pipe.mode"))
                gui.behaviour.pipeModeInt = NbtUtil.getInt(nbt, "teleport_pipe.mode");

            if (NbtUtil.has(nbt, "teleport_pipe.is_public"))
                gui.behaviour.modeIsPublic = NbtUtil.getBoolean(nbt, "teleport_pipe.is_public");

        }));
    }

    // とりあえずTagで管理する
    public static void send(NbtCompound tag) {
        PacketByteBuf buf = PacketByteUtil.create();
        buf.writeNbt(tag);
        ClientNetworking.send(id, buf);
    }

    public static void send(String key, String string) {
        NbtCompound tag = createNbt();
        NbtUtil.putString(tag, "type", "string");
        NbtUtil.putString(tag, key, string);
        send(tag);
    }

    public static void send(String key, Integer integer) {
        NbtCompound tag = createNbt();
        NbtUtil.putString(tag, "type", "integer");
        NbtUtil.putInt(tag, key, integer);
        send(tag);
    }

    public static void send(String key, Boolean bool) {
        NbtCompound tag = createNbt();
        NbtUtil.putString(tag, "type", "bool");
        NbtUtil.putBoolean(tag, key, bool);
        send(tag);
    }

    public static void send(String key, UUID uuid) {
        NbtCompound tag = createNbt();
        NbtUtil.putString(tag, "type", "uuid");
        NbtUtil.putUuid(tag, key, uuid);
        send(tag);
    }

    public static void send(String key, Byte b) {
        NbtCompound tag = createNbt();
        NbtUtil.putString(tag, "type", "byte");
        NbtUtil.putByte(tag, key, b);
        send(tag);
    }

    public static void send(String key, Double d) {
        NbtCompound tag = createNbt();
        NbtUtil.putString(tag, "type", "double");
        NbtUtil.putDouble(tag, key, d);
        send(tag);
    }

    public static void send(String key, Float f) {
        NbtCompound tag = createNbt();
        NbtUtil.putString(tag, "type", "float");
        NbtUtil.putFloat(tag, key, f);
        send(tag);
    }

    public static void send(String key, Short s) {
        NbtCompound tag = createNbt();
        NbtUtil.putString(tag, "type", "short");
        NbtUtil.putShort(tag, key, s);
        send(tag);
    }

    public static void send(String key, Long l) {
        NbtCompound tag = createNbt();
        NbtUtil.putString(tag, "type", "long");
        NbtUtil.putLong(tag, key, l);
        send(tag);
    }

    public static NbtCompound createNbt() {
        return NbtUtil.create();
    }


}
