package com.champ.lefthand;

import com.champ.lefthand.mixins.MixinGameSettings;
import com.champ.lefthand.usage.ToggleScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.fabricmc.api.ModInitializer;

public class LeftyMod implements ModInitializer{

    public static LeftyMod INSTANCE = new LeftyMod();

    private static Minecraft mc = Minecraft.getMinecraft();

    @Override
    public void onInitialize(){
        System.out.println("STARTING MOD-------------------------------------------");
    }
}
