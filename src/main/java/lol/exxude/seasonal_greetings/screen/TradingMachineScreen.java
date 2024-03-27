package lol.exxude.seasonal_greetings.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import lol.exxude.seasonal_greetings.SeasonalGreetings;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class TradingMachineScreen extends AbstractContainerScreen<TradingMachineMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(SeasonalGreetings.MOD_ID, "textures/screens/trading_machine_gui.png");

    public TradingMachineScreen(TradingMachineMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        //this.inventoryLabelY = 10000;
        //this.titleLabelY = 1000;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, 176, 166, 176, 166);
        guiGraphics.blit(new ResourceLocation("seasonal_greetings:textures/screens/progress0.png"), x + 88, y + 42, 0, 0, 22, 11, 22, 11);

        renderProgressArrow(guiGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            if(menu.getScaledProgress() == 1) {
                guiGraphics.blit(new ResourceLocation("seasonal_greetings:textures/screens/progress1.png"), x + 88, y + 42, 0, 0, 22, 11, 22, 11);
            }
            else if(menu.getScaledProgress() == 2) {
                guiGraphics.blit(new ResourceLocation("seasonal_greetings:textures/screens/progress2.png"), x + 88, y + 42, 0, 0, 22, 11, 22, 11);
            }
            else if(menu.getScaledProgress() == 3) {
                guiGraphics.blit(new ResourceLocation("seasonal_greetings:textures/screens/progress3.png"), x + 88, y + 42, 0, 0, 22, 11, 22, 11);
            }
            else if(menu.getScaledProgress() == 4) {
                guiGraphics.blit(new ResourceLocation("seasonal_greetings:textures/screens/progress4.png"), x + 88, y + 42, 0, 0, 22, 11, 22, 11);
            }
            else if(menu.getScaledProgress() == 5) {
                guiGraphics.blit(new ResourceLocation("seasonal_greetings:textures/screens/progress5.png"), x + 88, y + 42, 0, 0, 22, 11, 22, 11);
            }
            else if(menu.getScaledProgress() == 6) {
                guiGraphics.blit(new ResourceLocation("seasonal_greetings:textures/screens/progress6.png"), x + 88, y + 42, 0, 0, 22, 11, 22, 11);
            }
            else if(menu.getScaledProgress() == 7) {
                guiGraphics.blit(new ResourceLocation("seasonal_greetings:textures/screens/progress7.png"), x + 88, y + 42, 0, 0, 22, 11, 22, 11);
            }
            else if(menu.getScaledProgress() == 8) {
                guiGraphics.blit(new ResourceLocation("seasonal_greetings:textures/screens/progress8.png"), x + 88, y + 42, 0, 0, 22, 11, 22, 11);
            }
            else if(menu.getScaledProgress() == 9) {
                guiGraphics.blit(new ResourceLocation("seasonal_greetings:textures/screens/progress9.png"), x + 88, y + 42, 0, 0, 22, 11, 22, 11);
            }
            else if(menu.getScaledProgress() == 10) {
                guiGraphics.blit(new ResourceLocation("seasonal_greetings:textures/screens/progress10.png"), x + 88, y + 42, 0, 0, 22, 11, 22, 11);
            }
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}
