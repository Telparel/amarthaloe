package com.amartaloe.mod.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import org.lwjgl.glfw.GLFW;

@EventBusSubscriber(modid = "amartaloe", value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ModKeyMappings {
    public static final KeyMapping OPEN_MENU_KEY = new KeyMapping(
            "key.amartaloe.open_menu",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_L,
            "category.amartaloe.title"
    );

    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event) {
        event.register(OPEN_MENU_KEY);
    }
}
