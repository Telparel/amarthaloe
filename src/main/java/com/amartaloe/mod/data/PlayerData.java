package com.amartaloe.mod.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;

import java.util.HashMap;
import java.util.Map;

public class PlayerData {
    private int level;
    private int experience;
    private final Map<String, Integer> factionReputation;

    public PlayerData() {
        this.level = 1;
        this.experience = 0;
        this.factionReputation = new HashMap<>();
    }

    public PlayerData(int level, int experience, Map<String, Integer> factionReputation) {
        this.level = level;
        this.experience = experience;
        this.factionReputation = new HashMap<>(factionReputation);
    }

    // Codec для автоматической сериализации NeoForge
    public static final Codec<PlayerData> CODEC = RecordCodecBuilder.create(instance ->
        instance.group(
            Codec.INT.fieldOf("level").forGetter(PlayerData::getLevel),
            Codec.INT.fieldOf("experience").forGetter(PlayerData::getExperience),
            Codec.unboundedMap(Codec.STRING, Codec.INT).fieldOf("factions").forGetter(PlayerData::getFactionReputation)
        ).apply(instance, PlayerData::new)
    );

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }

    public Map<String, Integer> getFactionReputation() { return factionReputation; }

    public int getReputation(String factionId) {
        return factionReputation.getOrDefault(factionId, 0);
    }

    public void addReputation(String factionId, int amount) {
        factionReputation.put(factionId, getReputation(factionId) + amount);
    }
}
