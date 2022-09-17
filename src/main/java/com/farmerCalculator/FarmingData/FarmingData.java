package com.farmerCalculator.FarmingData;

import com.farmerCalculator.Exchange.Exchange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Fetches relevant farming data.
public class FarmingData {
    private final Map<String, String> SeedToId = new HashMap<String, String>() {
        { put("Guam seed", "5291"); }
        { put("Marrentill seed", "5292"); }
        { put("Tarromin seed", "5293"); }
        { put("Harralander seed", "5294"); }
        { put("Ranarr seed", "5295"); }
        { put("Toadflax seed", "5296"); }
        { put("Irit seed", "5297"); }
        { put("Avantoe seed", "5298"); }
        { put("Kwuarm seed", "5299"); }
        { put("Snapdragon seed", "5300"); }
        { put("Cadantine seed", "5301"); }
        { put("Lantadyme seed", "5302"); }
        { put("Dwarf weed seed", "5303"); }
        { put("Torstol seed", "5304"); }
    };

    public Map<String, Integer> getSeedToPrice() {
        return Exchange.getValueForItems(new ArrayList<String>(SeedToId.values()));
    }
}
