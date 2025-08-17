package com.champ.lefthand.usage;

import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;

import static com.champ.lefthand.LeftyMod.mc;

public class ToggleScreen extends Screen {

    public static boolean isEnabled;

    @Override
    public void init() {
        this.buttons.add(new ButtonWidget(0, 5, 5, mc.textRenderer.getStringWidth("X") + 10, textRenderer.fontHeight + 10, "X"));
        this.buttons.add(new ButtonWidget(1, 100, 5, mc.textRenderer.getStringWidth("Left Hand On") + 10, textRenderer.fontHeight + 5, "Left Hand On"));
        this.buttons.add(new ButtonWidget(2, 100, 50, mc.textRenderer.getStringWidth("left Hand Off") + 10, mc.textRenderer.fontHeight + 5, "Left Hand Off"));

    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        renderBackground(0);
        // Was there.?
        //mc.textRenderer.drawWithShadow("MY FIRST MOD", (float) this.width / 2 - 50, (float) this.height / 2 - 50, -1);
        super.render(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void buttonClicked(ButtonWidget button) {
        if (button.id == 0) {
            mc.setScreen(new GameMenuScreen());
        }
        if (button.id == 1) {
            isEnabled = true;
        }
        if (button.id == 2) {
            isEnabled = false;
        }
    }
}
