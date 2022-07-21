package net.ramgaming.leapers.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.ramgaming.leapers.Leapers;

public class SkyGazerScreen extends HandledScreen<SkyGazerScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(Leapers.MOD_ID,"textures/gui/sky_gazer_gui.png");
    public SkyGazerScreen(SkyGazerScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F,1.0F,1.0F,1.0F);
        RenderSystem.setShaderTexture(0,TEXTURE);
        int x = (width - backgroundWidth) /2;
        int y = (height - backgroundHeight) /2;
        drawTexture(matrices,x,y,0,0,backgroundWidth,backgroundHeight);
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title))/2;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX,int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices,mouseX,mouseY,delta);
        drawMouseoverTooltip(matrices,mouseX,mouseY);
    }
}