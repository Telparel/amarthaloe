package com.amartaloe.mod.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.HashMap;
import java.util.Map;

public class PlayerData {
    // 7 каноничных регионов Амарталоэ
    public static final String[] REGIONS = {
        "caligo", "maris", "libra", "gnoster", "gladius", "fulgort", "adel"
    };

    // RP-Паспорт
    private String gender = "Не указан";
    private String heightWeight = "— / —";
    private String appearanceHair = "—";
    private String appearanceEyes = "—";
    private String appearanceBody = "—";
    private String specialMarks = "Шрамы, татуировки отсутствуют";
    private String backstory = "Память затуманена пеплом...";
    private String activeTitle = "Скиталец";

    // Репутация в 7 регионах (от -1000 до +1000)
    private final Map<String, Integer> reputations = new HashMap<>();

    public PlayerData() {
        for (String region : REGIONS) {
            reputations.put(region, 0); // По умолчанию нейтралитет
        }
    }

    public PlayerData(String gender, String heightWeight, String appearanceHair, 
                      String appearanceEyes, String appearanceBody, String specialMarks, 
                      String backstory, String activeTitle, Map<String, Integer> reps) {
        this.gender = gender;
        this.heightWeight = heightWeight;
        this.appearanceHair = appearanceHair;
        this.appearanceEyes = appearanceEyes;
        this.appearanceBody = appearanceBody;
        this.specialMarks = specialMarks;
        this.backstory = backstory;
        this.activeTitle = activeTitle;
        this.reputations.putAll(reps);
    }

    public static final Codec<PlayerData> CODEC = RecordCodecBuilder.create(inst ->
        inst.group(
            Codec.STRING.fieldOf("gender").forGetter(p -> p.gender),
            Codec.STRING.fieldOf("heightWeight").forGetter(p -> p.heightWeight),
            Codec.STRING.fieldOf("appearanceHair").forGetter(p -> p.appearanceHair),
            Codec.STRING.fieldOf("appearanceEyes").forGetter(p -> p.appearanceEyes),
            Codec.STRING.fieldOf("appearanceBody").forGetter(p -> p.appearanceBody),
            Codec.STRING.fieldOf("specialMarks").forGetter(p -> p.specialMarks),
            Codec.STRING.fieldOf("backstory").forGetter(p -> p.backstory),
            Codec.STRING.fieldOf("activeTitle").forGetter(p -> p.activeTitle),
            Codec.unboundedMap(Codec.STRING, Codec.INT).fieldOf("reputations").forGetter(p -> p.reputations)
        ).apply(inst, PlayerData::new)
    );

    // Геттеры и сеттеры
    public int getReputation(String region) { return reputations.getOrDefault(region, 0); }
    public void setReputation(String region, int value) { reputations.put(region, Math.clamp(value, -1000, 1000)); }
    public void addReputation(String region, int delta) { setReputation(region, getReputation(region) + delta); }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getHeightWeight() { return heightWeight; }
    public void setHeightWeight(String heightWeight) { this.heightWeight = heightWeight; }

    public String getAppearanceHair() { return appearanceHair; }
    public void setAppearanceHair(String appearanceHair) { this.appearanceHair = appearanceHair; }

    public String getAppearanceEyes() { return appearanceEyes; }
    public void setAppearanceEyes(String appearanceEyes) { this.appearanceEyes = appearanceEyes; }

    public String getAppearanceBody() { return appearanceBody; }
    public void setAppearanceBody(String appearanceBody) { this.appearanceBody = appearanceBody; }

    public String getSpecialMarks() { return specialMarks; }
    public void setSpecialMarks(String specialMarks) { this.specialMarks = specialMarks; }

    public String getBackstory() { return backstory; }
    public void setBackstory(String backstory) { this.backstory = backstory; }

    public String getActiveTitle() { return activeTitle; }
    public void setActiveTitle(String activeTitle) { this.activeTitle = activeTitle; }
}
