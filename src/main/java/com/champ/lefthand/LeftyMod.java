package com.champ.lefthand;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;

public class LeftyMod implements ModInitializer {
    // Was never used.
    //public static LeftyMod INSTANCE = new LeftyMod();

    public static MinecraftClient mc = MinecraftClient.getInstance();

    @Override
    public void onInitialize() {
        System.out.println("STARTING MOD-------------------------------------------");
    }
}
