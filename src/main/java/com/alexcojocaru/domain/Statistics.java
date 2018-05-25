package com.alexcojocaru.domain;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;

@Data
public class Statistics implements Comparable<Statistics> {
    private HsSet set;
    private List<HsCard> cards;
    private double packChance;

    public Statistics(HsSet set, List<HsCard> cards) {
        this.set = set;
        this.cards = cards;
        this.packChance = cards.stream().mapToDouble(card -> card.getRarity().getPackChance()).sum();
    }

    @Override
    public int compareTo(Statistics o) {
        return Double.compare(this.packChance, o.packChance);
    }

    @Override
    public String toString() {
        return "Statistics for " + set.getName() + ":\n"
                + "\tPack chance: " + packChance + "\n"
                + "\tTotal cards: " + cards.size() + "\n"
                + "\tCards:\n"
                + cards.stream().map(card -> "\t\t" + card.toString()).collect(Collectors.joining("\n"));
    }
}
