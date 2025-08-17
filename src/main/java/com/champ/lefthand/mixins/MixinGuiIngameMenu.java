package com.champ.lefthand.mixins;

import com.champ.lefthand.usage.ToggleScreen;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.champ.lefthand.LeftyMod.mc;

@Mixin(GameMenuScreen.class)
public class MixinGuiIngameMenu extends Screen {

    @Inject(method = "init", at = @At(value = "RETURN"))
    private void init(CallbackInfo ci) {
        buttons.add(new ButtonWidget(600, 5, 5, mc.textRenderer.getStringWidth("LEFT HAND") + 10, textRenderer.fontHeight + 5, "LEFT HAND"));
        // Was there.?
        //System.out.println("INIT GUI");
    }

    @Inject(method = "buttonClicked", at = @At(value = "HEAD"), cancellable = true)
    protected void buttonClicked(ButtonWidget button, CallbackInfo ci) {
        if (button.id == 600) {
            // Was there.?
            //System.out.println("INIT TOGGLE SCREEN");
            mc.setScreen(new ToggleScreen());
            ci.cancel();
        }
    }
}
