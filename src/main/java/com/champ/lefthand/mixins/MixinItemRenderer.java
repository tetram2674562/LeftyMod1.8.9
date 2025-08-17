package com.champ.lefthand.mixins;

import com.champ.lefthand.usage.ToggleScreen;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.render.item.HeldItemRenderer;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HeldItemRenderer.class)
public class MixinItemRenderer {

    @Inject(method = "renderArmHoldingItem", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/platform/GlStateManager;pushMatrix()V", shift = At.Shift.AFTER))
    private void renderItemInFirstPerson(float partialTicks, CallbackInfo ci) {
        // Was there.?
        //System.out.println("Mixin worked!:))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))");
        if(ToggleScreen.isEnabled) {
            GL11.glScaled(-1.0D, 1.0D, 1.0D);
            GlStateManager.disableCull();
        }
    }
}
