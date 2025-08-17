package com.champ.lefthand.mixins;

import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import org.apache.commons.lang3.ArrayUtils;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameOptions.class)
public class MixinGameSettings {

    @Unique
    public final KeyBinding OPEN_GUI = new KeyBinding("Open Gui", Keyboard.KEY_H, "Left Hand");

    @Shadow
    public KeyBinding[] allKeys;

    @Unique
    private void addKeybinds() {
        this.allKeys = ArrayUtils.add(this.allKeys, this.OPEN_GUI);
    }

    @Inject(at = @At("RETURN"), method = "<init>()V")
    private void injectFirstConstructor(CallbackInfo ci) {
        this.addKeybinds();
    }

    @Inject(at = @At("RETURN"), method = "<init>(Lnet/minecraft/client/MinecraftClient;Ljava/io/File;)V")
    private void injectSecondConstructor(CallbackInfo ci) {
        this.addKeybinds();
    }
}
