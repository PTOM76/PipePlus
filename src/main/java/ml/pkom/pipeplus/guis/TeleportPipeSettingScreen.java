package ml.pkom.pipeplus.guis;

import ml.pkom.mcpitanlibarch.api.util.TextUtil;
import ml.pkom.mcpitanlibarch.api.util.client.ScreenUtil;
import ml.pkom.pipeplus.PipePlus;
import ml.pkom.pipeplus.ServerNetwork;
import ml.pkom.pipeplus.blockentities.PipeItemsTeleportEntity;
import ml.pkom.pipeplus.blocks.Blocks;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class TeleportPipeSettingScreen extends HandledScreen<TeleportPipeSettingHandler> {
    private static final Identifier GUI = PipePlus.id("textures/gui/background_generic.png");

    public PipeItemsTeleportEntity tile;

    public String owner = "null";

    public void pipeModeBtnUpdate() {
        ServerNetwork.send("teleport_pipe.mode", tile.pipeModeInt);
        if (tile.pipeModeInt == 0) pipeMode.setMessage(TextUtil.translatable("button.pipeplus.teleport_pipe_setting.pipeMode.sendOnly"));
        if (tile.pipeModeInt == 1) pipeMode.setMessage(TextUtil.translatable("button.pipeplus.teleport_pipe_setting.pipeMode.receive_only"));
        if (tile.pipeModeInt == 2) pipeMode.setMessage(TextUtil.translatable("button.pipeplus.teleport_pipe_setting.pipeMode.send_and_receive"));
        if (tile.pipeModeInt == 3) pipeMode.setMessage(TextUtil.translatable("button.pipeplus.teleport_pipe_setting.pipeMode.disabled"));
    }

    public void openModeBtnUpdate() {
        ServerNetwork.send("teleport_pipe.is_public", tile.modeIsPublic);
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
    }));

    public ButtonWidget openMode = ScreenUtil.createButtonWidget(114, 35, 102, 20, TextUtil.translatable("button.pipeplus.teleport_pipe_setting.openMode.private"), (button -> {
        if (tile.modeIsPublic) {
            tile.modeIsPublic = false;
            button.setMessage(TextUtil.translatable("button.pipeplus.teleport_pipe_setting.openMode.private"));
        } else {
            tile.modeIsPublic = true;
            button.setMessage(TextUtil.translatable("button.pipeplus.teleport_pipe_setting.openMode.public"));
        }
    }));
    public ButtonWidget numberAddー100 = ScreenUtil.createButtonWidget(12, 78, 34, 20, TextUtil.literal("-100"), (button -> {
        addFrequency(-100);
    }));
    public ButtonWidget numberAddー10 = ScreenUtil.createButtonWidget(46, 78, 34, 20, TextUtil.literal("-10"), (button -> {
        addFrequency(-10);
    }));
    public ButtonWidget numberAddー1 = ScreenUtil.createButtonWidget(80, 78, 34, 20, TextUtil.literal("-1"), (button -> {
        addFrequency(-1);
    }));
    public ButtonWidget numberAdd十1 = ScreenUtil.createButtonWidget(114, 78, 34, 20, TextUtil.literal("+1"), (button -> {
        addFrequency(1);
    }));
    public ButtonWidget numberAdd十10 = ScreenUtil.createButtonWidget(148, 78, 34, 20, TextUtil.literal("+10"), (button -> {
        addFrequency(10);
    }));
    public ButtonWidget numberAdd十100 = ScreenUtil.createButtonWidget(182, 78, 34, 20, TextUtil.literal("+100"), (button -> {
        addFrequency(100);
    }));


    public void addFrequency(int i) {
        int newFrequency = Math.max(tile.frequency + i, 0);
        tile.frequency = newFrequency;

        ServerNetwork.send("teleport_pipe.frequency", newFrequency);
    }

    public TeleportPipeSettingScreen(TeleportPipeSettingHandler container, PlayerInventory inv, Text title) {
        super(container, container.player.getInventory(), Blocks.PIPE_ITEMS_TELEPORT.getName());
        tile = container.tile;

        pipeModeBtnUpdate();
        openModeBtnUpdate();
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
        numberAddー100.x =(12 + x);
        numberAddー100.y =(78 + y);
        numberAddー10.x =(46 + x);
        numberAddー10.y =(78 + y);
        numberAddー1.x =(80 + x);
        numberAddー1.y =(78 + y);
        numberAdd十1.x =(114 + x);
        numberAdd十1.y =(78 + y);
        numberAdd十10.x =(148 + x);
        numberAdd十10.y =(78 + y);
        numberAdd十100.x =(182 + x);
        numberAdd十100.y =(78 + y);
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
        int posX = handler.tile.getPos().getX();
        int posY = handler.tile.getPos().getY();
        int posZ = handler.tile.getPos().getZ();

        x = (this.width - this.backgroundWidth) / 2;
        y = (this.height - this.backgroundHeight) / 2;
        this.textRenderer.draw(matrices, this.title, 71, 7, 0x0a0c84);
        this.textRenderer.draw(matrices, TextUtil.translatable("label.pipeplus.teleport_pipe_setting.owner", handler.tile.ownerName), 12, 22, 4210752);
        this.textRenderer.draw(matrices, TextUtil.translatable("label.pipeplus.teleport_pipe_setting.coords", posX, posY, posZ), 110, 22, 4210752);
        this.textRenderer.draw(matrices, TextUtil.translatable("label.pipeplus.teleport_pipe_setting.frequency", handler.tile.frequency), 16, 68, 4210752);
    }

    @Override
    protected void init() {
        super.init();

        this.backgroundWidth = 227;
        this.backgroundHeight = 116;
    }
}
