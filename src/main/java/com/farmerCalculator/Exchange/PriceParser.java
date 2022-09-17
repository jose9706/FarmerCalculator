package com.farmerCalculator.Exchange;

import org.jetbrains.annotations.NotNull;

// Parser GE prices correctly.
public class PriceParser {
    public static String Millions = "m";
    public static String Thousands = "k";
    public static int ThousandMultiplier = 1000;
    public static int MillionMultiplier = ThousandMultiplier*ThousandMultiplier;

    public static int GetPrice(@NotNull String priceString) {
        int result = 0;
        if(priceString.contains(Millions)) {
            priceString = priceString.replace(Millions, "");
            double temp = Double.parseDouble(priceString);
            result = (int) (temp * MillionMultiplier);
            return result;
        }
        if(priceString.contains(Thousands)) {
            priceString = priceString.replace(Thousands, "");
            double temp = Double.parseDouble(priceString);
            result = (int) (temp * ThousandMultiplier);
            return result;
        }
        priceString = priceString.replace(",", "");
        result = Integer.parseInt(priceString);
        return result;
    }
}
