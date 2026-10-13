package com.amartaloe.mod.client;

import com.amartaloe.mod.client.gui.AmartaloeMenuScreen;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;

@EventBusSubscriber(modid = "amartaloe", value = Dist.CLIENT)
public class ClientEventHandler {
    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player != null && ModKeyMappings.OPEN_MENU_KEY.consumeClick()) {
            mc.setScreen(new AmartaloeMenuScreen());
        }
    }
}
