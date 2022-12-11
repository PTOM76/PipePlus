package ml.pkom.pipeplus.guis;

import com.mojang.blaze3d.systems.RenderSystem;
import ml.pkom.mcpitanlibarch.api.util.TextUtil;
import ml.pkom.pipeplus.PipePlus;
import ml.pkom.pipeplus.ServerNetwork;
import ml.pkom.pipeplus.TeleportManager;
import ml.pkom.pipeplus.blockentities.PipeItemsTeleportEntity;
import ml.pkom.pipeplus.blocks.Blocks;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.UUID;

public class TeleportPipeSettingScreen extends HandledScreen<TeleportPipeSettingHandler> {
    public static final HandledScreens.Provider<TeleportPipeSettingHandler, TeleportPipeSettingScreen> FACTORY = TeleportPipeSettingScreen::new;
    private static final Identifier GUI = PipePlus.id("textures/gui/background_generic.png");

    public PipeItemsTeleportEntity tile;

    public String owner = "null";

    public void pipeModeBtnUpdate() {
        ServerNetwork.send("teleportPipe.mode", tile.pipeModeInt);
        if (tile.pipeModeInt == 0) pipeMode.setMessage(TextUtil.translatable("button.pipeplus.teleport_pipe_setting.pipeMode.sendOnly"));
        if (tile.pipeModeInt == 1) pipeMode.setMessage(TextUtil.translatable("button.pipeplus.teleport_pipe_setting.pipeMode.receive_only"));
        if (tile.pipeModeInt == 2) pipeMode.setMessage(TextUtil.translatable("button.pipeplus.teleport_pipe_setting.pipeMode.send_and_receive"));
        if (tile.pipeModeInt == 3) pipeMode.setMessage(TextUtil.translatable("button.pipeplus.teleport_pipe_setting.pipeMode.disabled"));
    }

    public void openModeBtnUpdate() {
        ServerNetwork.send("teleportPipe.isPublic", tile.modeIsPublic);
        if (tile.modeIsPublic) {
            openMode.setMessage(TextUtil.translatable("button.pipeplus.teleport_pipe_setting.openMode.public"));
        } else {
            openMode.setMessage(TextUtil.translatable("button.pipeplus.teleport_pipe_setting.openMode.private"));
        }
    }

    public ButtonWidget pipeMode = ButtonWidget.builder(TextUtil.translatable("button.pipeplus.teleport_pipe_setting.pipeMode.sendOnly"), (button -> {
        tile.pipeModeInt++;
        if (tile.pipeModeInt >= 4) tile.pipeModeInt = 0;
        pipeModeBtnUpdate();
    })).dimensions(12, 35, 102, 20).build();

    public ButtonWidget openMode = ButtonWidget.builder(TextUtil.translatable("button.pipeplus.teleport_pipe_setting.openMode.private"), (button -> {
        if (tile.modeIsPublic) {
            tile.modeIsPublic = false;
            button.setMessage(TextUtil.translatable("button.pipeplus.teleport_pipe_setting.openMode.private"));
        } else {
            tile.modeIsPublic = true;
            button.setMessage(TextUtil.translatable("button.pipeplus.teleport_pipe_setting.openMode.public"));
        }
    })).dimensions(114, 35, 102, 20).build();
    public ButtonWidget numberAddー100 = ButtonWidget.builder(TextUtil.literal("-100"), (button -> {
        addFrequency(-100);
    })).dimensions(12, 78, 34, 20).build();
    public ButtonWidget numberAddー10 = ButtonWidget.builder(TextUtil.literal("-10"), (button -> {
        addFrequency(-10);
    })).dimensions(46, 78, 34, 20).build();
    public ButtonWidget numberAddー1 = ButtonWidget.builder(TextUtil.literal("-1"), (button -> {
        addFrequency(-1);
    })).dimensions(80, 78, 34, 20).build();
    public ButtonWidget numberAdd十1 = ButtonWidget.builder(TextUtil.literal("+1"), (button -> {
        addFrequency(1);
    })).dimensions(114, 78, 34, 20).build();
    public ButtonWidget numberAdd十10 = ButtonWidget.builder(TextUtil.literal("+10"), (button -> {
        addFrequency(10);
    })).dimensions(148, 78, 34, 20).build();
    public ButtonWidget numberAdd十100 = ButtonWidget.builder(TextUtil.literal("+100"), (button -> {
        addFrequency(100);
    })).dimensions(182, 78, 34, 20).build();


    public void addFrequency(int i) {
        int m = tile.frequency;
        if (tile.frequency + i >= 0) {
            tile.frequency = tile.frequency + i;
        } else {
            tile.frequency = 0;
        }
        ServerNetwork.send("teleportPipe.frequency", tile.frequency);
        TeleportManager.instance.remove(tile, m);
        TeleportManager.instance.add(tile, tile.frequency);
    }

    private int posX;
    private int posY;
    private int posZ;

    public TeleportPipeSettingScreen(TeleportPipeSettingHandler container, PlayerInventory inv, Text title) {
        super(container, container.player.getInventory(), Blocks.PIPE_ITEMS_TELEPORT.getName());
        //tile = (PipeItemsTeleportEntity) container.player.getEntityWorld().getBlockEntity(container.tile.getPos());
        //tile = container.tile;
        tile = PipeItemsTeleportEntity.tileMap.get(PipePlus.pos2str(container.tile.getPos()));
        posX = tile.getPos().getX();
        posY = tile.getPos().getY();
        posZ = tile.getPos().getZ();

        if(tile.owner != null) {
            if (tile.owner.equals(UUID.fromString("00000000-0000-0000-0000-000000000000"))) {
                owner = tile.ownerName;
            } else {
                try {
                    tile.ownerName = tile.getWorld().getPlayerByUuid(tile.owner).getName().getString();
                    owner = tile.ownerName;
                } catch (NullPointerException e) {
                    owner = tile.ownerName;
                }
            }
        } else {
            owner = tile.ownerName;
        }

        pipeModeBtnUpdate();
        openModeBtnUpdate();
        this.backgroundWidth = 227;
        this.backgroundHeight = 116;
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    protected void drawBackground(MatrixStack matrices, float partialTicks, int mouseX, int mouseY) {
        //GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);

        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI);

        //MinecraftClient.getInstance().getTextureManager().bindTexture(GUI);
        int x = (this.width - this.backgroundWidth) / 2;
        int y = (this.height - this.backgroundHeight) / 2;
        this.drawTexture(matrices, x, y, 0, 0, this.backgroundWidth, this.backgroundHeight);
        pipeMode.setX(12 + x);
        pipeMode.setY(35 + y);
        openMode.setX(114 + x);
        openMode.setY(35 + y);
        numberAddー100.setX(12 + x);
        numberAddー100.setY(78 + y);
        numberAddー10.setX(46 + x);
        numberAddー10.setY(78 + y);
        numberAddー1.setX(80 + x);
        numberAddー1.setY(78 + y);
        numberAdd十1.setX(114 + x);
        numberAdd十1.setY(78 + y);
        numberAdd十10.setX(148 + x);
        numberAdd十10.setY(78 + y);
        numberAdd十100.setX(182 + x);
        numberAdd十100.setY(78 + y);
        this.addDrawable(pipeMode);
        this.addDrawable(openMode);
        this.addDrawable(numberAddー100);
        this.addDrawable(numberAddー10);
        this.addDrawable(numberAddー1);
        this.addDrawable(numberAdd十1);
        this.addDrawable(numberAdd十10);
        this.addDrawable(numberAdd十100);

        this.addSelectableChild(pipeMode);
        this.addSelectableChild(openMode);
        this.addSelectableChild(numberAddー100);
        this.addSelectableChild(numberAddー10);
        this.addSelectableChild(numberAddー1);
        this.addSelectableChild(numberAdd十1);
        this.addSelectableChild(numberAdd十10);
        this.addSelectableChild(numberAdd十100);
    }

    protected void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {
        x = (this.width - this.backgroundWidth) / 2;
        y = (this.height - this.backgroundHeight) / 2;
        this.textRenderer.draw(matrices, this.title, 71, 7, 0x0a0c84);
        this.textRenderer.draw(matrices, TextUtil.translatable("label.pipeplus.teleport_pipe_setting.owner", owner), 12, 22, 4210752);
        this.textRenderer.draw(matrices, TextUtil.translatable("label.pipeplus.teleport_pipe_setting.coords", posX, posY, posZ), 110, 22, 4210752);
        this.textRenderer.draw(matrices, TextUtil.translatable("label.pipeplus.teleport_pipe_setting.frequency", tile.frequency), 16, 68, 4210752);
    }
}
