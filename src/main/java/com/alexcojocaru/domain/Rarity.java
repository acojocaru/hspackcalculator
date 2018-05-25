package com.alexcojocaru.domain;

public enum Rarity {
    COMMON(0.9997), RARE(0.9566), EPIC(0.2056), LEGENDARY(0.0513), FREE(0.0);

    private double packChance;

    Rarity(double packChance) {
        this.packChance = packChance;
    }

    public double getPackChance() {
        return packChance;
    }
}
