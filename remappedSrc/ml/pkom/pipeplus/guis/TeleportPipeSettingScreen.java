package ml.pkom.pipeplus.guis;

import com.mojang.blaze3d.systems.RenderSystem;
import ml.pkom.pipeplus.PipePlus;
import ml.pkom.pipeplus.ServerNetwork;
import ml.pkom.pipeplus.TeleportManager;
import ml.pkom.pipeplus.blockentities.PipeItemsTeleportEntity;
import ml.pkom.pipeplus.blocks.Blocks;
import net.fabricmc.fabric.api.client.screen.ContainerScreenFactory;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

import java.util.UUID;

public class TeleportPipeSettingScreen extends HandledScreen<TeleportPipeSettingHandler> {
    public static final ContainerScreenFactory<TeleportPipeSettingHandler> FACTORY = TeleportPipeSettingScreen::new;
    private static final Identifier GUI = PipePlus.id("textures/gui/background_generic.png");

    public PipeItemsTeleportEntity tile;

    public String owner = "null";

    public void pipeModeBtnUpdate() {
        ServerNetwork.send("teleportPipe.mode", tile.pipeModeInt);
        if (tile.pipeModeInt == 0) pipeMode.setMessage(new TranslatableText("button.pipeplus.teleport_pipe_setting.pipeMode.sendOnly"));
        if (tile.pipeModeInt == 1) pipeMode.setMessage(new TranslatableText("button.pipeplus.teleport_pipe_setting.pipeMode.receive_only"));
        if (tile.pipeModeInt == 2) pipeMode.setMessage(new TranslatableText("button.pipeplus.teleport_pipe_setting.pipeMode.send_and_receive"));
        if (tile.pipeModeInt == 3) pipeMode.setMessage(new TranslatableText("button.pipeplus.teleport_pipe_setting.pipeMode.disabled"));
    }

    public void openModeBtnUpdate() {
        ServerNetwork.send("teleportPipe.isPublic", tile.modeIsPublic);
        if (tile.modeIsPublic) {
            openMode.setMessage(new TranslatableText("button.pipeplus.teleport_pipe_setting.openMode.public"));
        } else {
            openMode.setMessage(new TranslatableText("button.pipeplus.teleport_pipe_setting.openMode.private"));
        }
    }

    public ButtonWidget pipeMode = new ButtonWidget(12, 35, 102, 20, new TranslatableText("button.pipeplus.teleport_pipe_setting.pipeMode.sendOnly"), (button -> {
        tile.pipeModeInt++;
        if (tile.pipeModeInt >= 4) tile.pipeModeInt = 0;
        pipeModeBtnUpdate();
    }));

    public ButtonWidget openMode = new ButtonWidget(114, 35, 102, 20, new TranslatableText("button.pipeplus.teleport_pipe_setting.openMode.private"), (button -> {
        if (tile.modeIsPublic) {
            tile.modeIsPublic = false;
            button.setMessage(new TranslatableText("button.pipeplus.teleport_pipe_setting.openMode.private"));
        } else {
            tile.modeIsPublic = true;
            button.setMessage(new TranslatableText("button.pipeplus.teleport_pipe_setting.openMode.public"));
        }
    }));
    public ButtonWidget numberAddー100 = new ButtonWidget(12, 78, 34, 20, new LiteralText("-100"), (button -> {
        addFrequency(-100);
    }));
    public ButtonWidget numberAddー10 = new ButtonWidget(46, 78, 34, 20, new LiteralText("-10"), (button -> {
        addFrequency(-10);
    }));
    public ButtonWidget numberAddー1 = new ButtonWidget(80, 78, 34, 20, new LiteralText("-1"), (button -> {
        addFrequency(-1);
    }));
    public ButtonWidget numberAdd十1 = new ButtonWidget(114, 78, 34, 20, new LiteralText("+1"), (button -> {
        addFrequency(1);
    }));
    public ButtonWidget numberAdd十10 = new ButtonWidget(148, 78, 34, 20, new LiteralText("+10"), (button -> {
        addFrequency(10);
    }));
    public ButtonWidget numberAdd十100 = new ButtonWidget(182, 78, 34, 20, new LiteralText("+100"), (button -> {
        addFrequency(100);
    }));


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

    public TeleportPipeSettingScreen(TeleportPipeSettingHandler container) {
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

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI);

        //MinecraftClient.getInstance().getTextureManager().bindTexture(GUI);
        int x = (this.width - this.backgroundWidth) / 2;
        int y = (this.height - this.backgroundHeight) / 2;
        this.drawTexture(matrices, x, y, 0, 0, this.backgroundWidth, this.backgroundHeight);
        pipeMode.x = 12 + x;
        pipeMode.y = 35 + y;
        openMode.x = 114 + x;
        openMode.y = 35 + y;
        numberAddー100.x = 12 + x;
        numberAddー100.y = 78 + y;
        numberAddー10.x = 46 + x;
        numberAddー10.y = 78 + y;
        numberAddー1.x = 80 + x;
        numberAddー1.y = 78 + y;
        numberAdd十1.x = 114 + x;
        numberAdd十1.y = 78 + y;
        numberAdd十10.x = 148 + x;
        numberAdd十10.y = 78 + y;
        numberAdd十100.x = 182 + x;
        numberAdd十100.y = 78 + y;
        this.addDrawable(pipeMode);
        this.addDrawable(openMode);
        this.addDrawable(numberAddー100);
        this.addDrawable(numberAddー10);
        this.addDrawable(numberAddー1);
        this.addDrawable(numberAdd十1);
        this.addDrawable(numberAdd十10);
        this.addDrawable(numberAdd十100);

        this.addChild(pipeMode);
        this.addChild(openMode);
        this.addChild(numberAddー100);
        this.addChild(numberAddー10);
        this.addChild(numberAddー1);
        this.addChild(numberAdd十1);
        this.addChild(numberAdd十10);
        this.addChild(numberAdd十100);
    }

    protected void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {
        x = (this.width - this.backgroundWidth) / 2;
        y = (this.height - this.backgroundHeight) / 2;
        this.textRenderer.draw(matrices, this.title, 71, 7, 0x0a0c84);
        this.textRenderer.draw(matrices, new TranslatableText("label.pipeplus.teleport_pipe_setting.owner", owner), 12, 22, 4210752);
        this.textRenderer.draw(matrices, new TranslatableText("label.pipeplus.teleport_pipe_setting.coords", posX, posY, posZ), 110, 22, 4210752);
        this.textRenderer.draw(matrices, new TranslatableText("label.pipeplus.teleport_pipe_setting.frequency", tile.frequency), 16, 68, 4210752);
    }
}
