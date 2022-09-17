package com.farmerCalculator.Exchange;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.farmerCalculator.Exchange.UrlHandler.getRawData;
import static com.farmerCalculator.Exchange.ExchangeJsonDataHandler.*;

public class Exchange {

    public static HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();    private static final String ExchangeBaseAPI = "https://secure.runescape.com/m=itemdb_oldschool/api/catalogue/detail.json?item=";

    public static int getValueForItem(int itemId) {
        // TODO somehow verify the json response is actually ok.
        String rawData = getRawData(ExchangeBaseAPI + itemId);
        return ExtractCurrentIntPrice(rawData);
    }

    public static Map<String, Integer> getValueForItems(List<String> items) {
        Map<String, Integer> results = new HashMap<>();
        items.forEach((item) -> {results.put(item, getValueForItem(Integer.parseInt(item)));});
        return results;
    }
}