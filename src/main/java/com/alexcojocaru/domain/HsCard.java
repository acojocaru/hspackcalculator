package com.alexcojocaru.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HsCard {
    private String name;
    private Rarity rarity;
    private HsSet set;
}
