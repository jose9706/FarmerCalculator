package com.farmerCalculator.Exchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

// Connects to an url and returns a connection.
public class UrlHandler {
    public static URLConnection GetConnection(String url) {
        try {
            return new URL(url).openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getRawData(String url) {
        try {
            URLConnection conn = UrlHandler.GetConnection(url);
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String data = getDataFromConnection(inputStream, bufferedReader);
            if (data != null) return data;
        }
        catch (Exception e) {
            return e.getMessage();
        }
        return null;
    }

    private static String getDataFromConnection(InputStream inputStream, BufferedReader bufferedReader) throws IOException {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.contains("{")) {
                inputStream.close();
                return line;
            }
        }
        return null;
    }
}
