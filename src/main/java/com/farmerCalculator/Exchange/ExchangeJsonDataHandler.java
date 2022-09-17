package com.farmerCalculator.Exchange;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

// Handles raw JSON data.
public class ExchangeJsonDataHandler {

    // Obtains value of a specific token. Considers the first level of Grand Exchange api is the item level.
    public static String ExtractTokenDataFromJsonData(String token, String rawData) {
        JsonObject obj = new JsonParser().parse(rawData).getAsJsonObject();
       return obj.get("item").getAsJsonObject().get(token).getAsString();
    }

    public static String ExtractCurrentStringPrice(String rawData) {
        JsonObject obj = new JsonParser().parse(rawData).getAsJsonObject();
        // Based on json payload format.
        return obj.get("item").getAsJsonObject().get("current").getAsJsonObject().get("price").getAsString();
    }

    public static int ExtractCurrentIntPrice(String rawData) {
        JsonObject obj = new JsonParser().parse(rawData).getAsJsonObject();
        // Based on json payload format.
        String price = obj.get("item").getAsJsonObject().get("current").getAsJsonObject().get("price").getAsString();
        return PriceParser.GetPrice(price);
    }
}
