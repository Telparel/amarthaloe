package com.amartaloe.mod.registry;

import com.amartaloe.mod.AmartaloeMod;
import com.amartaloe.mod.data.PlayerData;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModAttachments {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES =
            DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, AmartaloeMod.MODID);

    public static final Supplier<AttachmentType<PlayerData>> PLAYER_DATA =
            ATTACHMENT_TYPES.register("player_data", () -> AttachmentType.builder(PlayerData::new)
                    .serialize(PlayerData.CODEC)
                    .copyOnDeath() // Сохранять прогресс после смерти игрока
                    .build());
}
