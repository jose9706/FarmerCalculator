package com.farmerCalculator.Exchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Exchange {

    public static HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

    public static String getData(int itemID) {
        try {
            StringBuilder sb = new StringBuilder("https://api.rsbuddy.com/grandExchange?a=guidePrice&i=");
            sb.append(String.valueOf(itemID));
            InputStream inputStream = new URL(sb.toString()).openStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("{")) {
                    sb = new StringBuilder(line);
                    //Remove { and }
                    sb.deleteCharAt(0);
                    //sb.deleteCharAt((line.length() - 1));
                    return sb.toString();
                }
            }
        }
        catch (Exception e) {
            return e.getMessage();
        }
        return null;
    }

    public static String[] parseData(String data) {
        ArrayList<String> holder = new ArrayList<String>();
        String[] parts = data.split(","); //Now we have strings in format "x":y
        for (String s : parts) {
            s = s.replace("\"", ""); //Remove " - now in format x:y
            holder.add(s.split(":")[1]); //Extract y from format x:y
        }
        String[] ret = new String[holder.size()];
        return holder.toArray(ret);
    }

    private static final String BASE_URL = "http://services.runescape.com/m=itemdb_oldschool/api/catalogue/detail.json?item=";

    private static final int BILLION = 1000000000;
    private static final int MILLION = 1000000;
    private static final int THOUSAND = 1000;

    public static int getPrice(final int id) {
        URL url = null;
        try {
            url = new URL(BASE_URL + id);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        HttpURLConnection conn;
        try {
            conn = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            conn.setRequestMethod("GET");
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        }
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Accept","application/json");
        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line = reader.readLine();
            List<String> lines = reader.lines().collect(Collectors.toList());
            System.out.println("Got lines" + lines);
            String sub = line.substring(line.indexOf("\"price\":"));
            final String raw = sub.substring("\"price\":".length(), sub.indexOf("}"));

            if (raw.endsWith("b")) {
                return (int) Double.parseDouble(raw.substring(0, raw.length() - 1)) * BILLION;
            } else if (raw.endsWith("m")) {
                return (int) Double.parseDouble(raw.substring(0, raw.length() - 1)) * MILLION;
            } else if (raw.endsWith("k")) {
                return (int) Double.parseDouble(raw.substring(0, raw.length() - 1)) * THOUSAND;
            } else {
                return Integer.parseInt(raw);
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

}