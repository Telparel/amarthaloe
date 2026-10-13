package com.amartaloe.mod;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(AmartaloeMod.MODID)
public class AmartaloeMod {
    public static final String MODID = "amartaloe";

    public AmartaloeMod(IEventBus modEventBus) {
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Базовая инициализация Амарталоэ
    }
}
