package com.alexcojocaru.domain;

public enum HsSet {
    BRM("Blackrock Mountain"), CORE("Basic"), EXPERT1("Classic"), GANGS("Mean Streets of Gadgetzan"),
    GILNEAS("The Witchwood"), GVG("Goblins vs Gnomes"), HERO_SKINS("Hero Skins"), HOF("Hall of Fame"),
    ICECROWN("Knights of the Frozen Throne"), KARA("One Night in Karazhan"), LOE("League of Explorers"),
    LOOTAPALOOZA("Kobolds & Catacombs"), NAXX("Naxxramas"), OG("Whispers of the Old Gods"), TGT("The Grand Tournament"),
    UNGORO("Journey to Un'Goro");

    private String name;

    HsSet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
