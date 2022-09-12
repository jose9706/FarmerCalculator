package com.farmerCalculator.Exchange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.farmerCalculator.Exchange.UrlHandler.getRawData;

public class Exchange {

    public static HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
    private static final String ExchangeBaseAPI = "https://secure.runescape.com/m=itemdb_oldschool/api/catalogue/detail.json?item=";

    public static int getValueForItem(int itemId) {
        String rawData = getRawData(ExchangeBaseAPI + itemId);
        return 1;
    }

    public static Map<String, Integer> getValueForItems(List<String> items) {
        Map<String, Integer> results = new HashMap<>();
        items.forEach((item) -> {results.put(item, getValueForItem(Integer.parseInt(item)));});
        return results;
    }
    private static final int BILLION = 1000000000;
    private static final int MILLION = 1000000;
    private static final int THOUSAND = 1000;
}