package net.pitan76.pipeplus.guis;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.pitan76.mcpitanlib.api.util.TextUtil;
import net.pitan76.mcpitanlib.api.util.client.ScreenUtil;
import net.pitan76.pipeplus.PipePlus;
import net.pitan76.pipeplus.ServerNetwork;
import net.pitan76.pipeplus.blockentities.PipeItemsTeleportEntity;
import net.pitan76.pipeplus.blocks.Blocks;
import org.apache.logging.log4j.Level;

public class TeleportPipeSettingScreen extends HandledScreen<TeleportPipeSettingHandler> {
    private static final Identifier GUI = PipePlus.id("textures/gui/background_generic.png");

    public PipeItemsTeleportEntity tile;

    public void pipeModeBtnUpdate() {
        if (tile.pipeModeInt == 0) pipeMode.setMessage(TextUtil.translatable("button.pipeplus.teleport_pipe_setting.pipeMode.sendOnly"));
        if (tile.pipeModeInt == 1) pipeMode.setMessage(TextUtil.translatable("button.pipeplus.teleport_pipe_setting.pipeMode.receive_only"));
        if (tile.pipeModeInt == 2) pipeMode.setMessage(TextUtil.translatable("button.pipeplus.teleport_pipe_setting.pipeMode.send_and_receive"));
        if (tile.pipeModeInt == 3) pipeMode.setMessage(TextUtil.translatable("button.pipeplus.teleport_pipe_setting.pipeMode.disabled"));
    }

    public void openModeBtnUpdate() {
        if (tile.modeIsPublic) {
            openMode.setMessage(TextUtil.translatable("button.pipeplus.teleport_pipe_setting.openMode.public"));
        } else {
            openMode.setMessage(TextUtil.translatable("button.pipeplus.teleport_pipe_setting.openMode.private"));
        }
    }

    public ButtonWidget pipeMode = ScreenUtil.createButtonWidget(12, 35, 102, 20, TextUtil.translatable("button.pipeplus.teleport_pipe_setting.pipeMode.sendOnly"), (button -> {
        tile.pipeModeInt++;
        if (tile.pipeModeInt >= 4) tile.pipeModeInt = 0;
        pipeModeBtnUpdate();
        ServerNetwork.send("teleport_pipe.mode", tile.pipeModeInt);
    }));

    public ButtonWidget openMode = ScreenUtil.createButtonWidget(114, 35, 102, 20, TextUtil.translatable("button.pipeplus.teleport_pipe_setting.openMode.private"), (button -> {
        if (tile.modeIsPublic) {
            tile.modeIsPublic = false;
            button.setMessage(TextUtil.translatable("button.pipeplus.teleport_pipe_setting.openMode.private"));
        } else {
            tile.modeIsPublic = true;
            button.setMessage(TextUtil.translatable("button.pipeplus.teleport_pipe_setting.openMode.public"));
        }
        openModeBtnUpdate();
        ServerNetwork.send("teleport_pipe.is_public", tile.modeIsPublic);
    }));
    public ButtonWidget numberPull_100 = ScreenUtil.createButtonWidget(12, 85, 34, 20, TextUtil.literal("-100"), (button -> {
        addFrequency(-100);
    }));
    public ButtonWidget numberPull_10 = ScreenUtil.createButtonWidget(46, 85, 34, 20, TextUtil.literal("-10"), (button -> {
        addFrequency(-10);
    }));
    public ButtonWidget numberPull_1 = ScreenUtil.createButtonWidget(80, 85, 34, 20, TextUtil.literal("-1"), (button -> {
        addFrequency(-1);
    }));
    public ButtonWidget numberAdd_1 = ScreenUtil.createButtonWidget(114, 85, 34, 20, TextUtil.literal("+1"), (button -> {
        addFrequency(1);
    }));
    public ButtonWidget numberAdd_10 = ScreenUtil.createButtonWidget(148, 85, 34, 20, TextUtil.literal("+10"), (button -> {
        addFrequency(10);
    }));
    public ButtonWidget numberAdd_100 = ScreenUtil.createButtonWidget(182, 85, 34, 20, TextUtil.literal("+100"), (button -> {
        addFrequency(100);
    }));

    public TextFieldWidget frequencySetting = new TextFieldWidget(MinecraftClient.getInstance().textRenderer, 12, 60, 204, 20, TextUtil.literal("0")) {
        @Override
        public boolean charTyped(char chr, int modifiers) {
            if(!Character.isDigit(chr)) {
                return false;
            }

            return super.charTyped(chr, modifiers);
        }
    };

    public void addFrequency(int i) {
        int newFrequency = Math.max(tile.frequency + i, 0);

        setFrequency(newFrequency);
    }

    public void setFrequency(int value) {
        tile.frequency = value;
        frequencySetting.setText(String.valueOf(tile.frequency));

        ServerNetwork.send("teleport_pipe.frequency", value);
    }

    public TeleportPipeSettingScreen(TeleportPipeSettingHandler container, PlayerInventory inv, Text title) {
        super(container, container.player.getInventory(), Blocks.PIPE_ITEMS_TELEPORT.getName());
        tile = container.tile;
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    protected void drawBackground(MatrixStack matrices, float partialTicks, int mouseX, int mouseY) {
        ScreenUtil.setBackground(GUI);

        int x = (this.width - this.backgroundWidth) / 2;
        int y = (this.height - this.backgroundHeight) / 2;
        this.drawTexture(matrices, x, y, 0, 0, this.backgroundWidth, this.backgroundHeight);
        pipeMode.x = (12 + x);
        pipeMode.y =(35 + y);
        openMode.x =(114 + x);
        openMode.y =(35 + y);
        numberPull_100.x =(12 + x);
        numberPull_100.y =(85 + y);
        numberPull_10.x =(46 + x);
        numberPull_10.y =(85 + y);
        numberPull_1.x =(80 + x);
        numberPull_1.y =(85 + y);
        numberAdd_1.x =(114 + x);
        numberAdd_1.y =(85 + y);
        numberAdd_10.x =(148 + x);
        numberAdd_10.y =(85 + y);
        numberAdd_100.x =(182 + x);
        numberAdd_100.y =(85 + y);
        frequencySetting.x = (12 + x);
        frequencySetting.y = (60 + y);

        this.addButton(pipeMode);
        this.addButton(openMode);
        this.addButton(numberPull_100);
        this.addButton(numberPull_10);
        this.addButton(numberPull_1);
        this.addButton(numberAdd_1);
        this.addButton(numberAdd_10);
        this.addButton(numberAdd_100);
        this.addButton(frequencySetting);
    }

    protected void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {
        int posX = tile.getPos().getX();
        int posY = tile.getPos().getY();
        int posZ = tile.getPos().getZ();

        x = (this.width - this.backgroundWidth) / 2;
        y = (this.height - this.backgroundHeight) / 2;
        this.textRenderer.draw(matrices, this.title, 71, 7, 0x0a0c84);
        this.textRenderer.draw(matrices, TextUtil.translatable("label.pipeplus.teleport_pipe_setting.owner", tile.ownerName), 12, 22, 4210752);
        this.textRenderer.draw(matrices, TextUtil.translatable("label.pipeplus.teleport_pipe_setting.coords", posX, posY, posZ), 110, 22, 4210752);
    }

    @Override
    protected void init() {
        super.init();

        this.backgroundWidth = 227;
        this.backgroundHeight = 116;

        pipeModeBtnUpdate();
        openModeBtnUpdate();
        frequencySetting.setText(String.valueOf(tile.frequency));
    }

    @Override
    public void onClose() {
        try {
            int newFrequency = Math.max(Integer.parseInt(frequencySetting.getText()), 0);
            setFrequency(newFrequency);
        } catch (NumberFormatException e) {
            PipePlus.log(Level.ERROR, "Failed to parse frequency: " + frequencySetting.getText());
        }

        super.onClose();
    }
}
