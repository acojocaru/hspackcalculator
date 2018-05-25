package com.alexcojocaru;

import com.alexcojocaru.domain.HsCard;
import com.alexcojocaru.domain.HsSet;
import com.alexcojocaru.domain.Statistics;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class App {

    private static final String CSS_SELECTOR_CRAFTABLE = "div.craftable";
    private static final String CSS_SELECTOR_CARD_NAME = "span.card-name";
    private static final String HS_CARDS_FILE_NAME = "hs-cards.json";
    private static final String HS_POPULARITY_FILE_NAME = "hs-popularity.html";
    private static final String JSOUP_BASE_URI = "http://localhost/";

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        URL cardsFile = ClassLoader.getSystemResource(HS_CARDS_FILE_NAME);
        List<HsCard> cards = objectMapper.readValue(cardsFile, new TypeReference<List<HsCard>>() {
        });

        URL popularityFile = ClassLoader.getSystemResource(HS_POPULARITY_FILE_NAME);
        Document doc = Jsoup.parse(popularityFile.openStream(), StandardCharsets.UTF_8.name(), JSOUP_BASE_URI);
        Elements craftable = doc.select(CSS_SELECTOR_CRAFTABLE);
        Map<HsSet, List<HsCard>> craftableCards = craftable.stream().flatMap(element -> {
            String cardName = element.select(CSS_SELECTOR_CARD_NAME).first().text();
            return cards.stream().filter(card -> card.getName().equals(cardName));
        }).collect(Collectors.groupingBy(HsCard::getSet));

        Set<Statistics> statistics = new TreeSet<>();
        craftableCards.keySet().forEach(set -> statistics.add(new Statistics(set, craftableCards.get(set))));

        statistics.forEach(System.out::println);
    }
}
