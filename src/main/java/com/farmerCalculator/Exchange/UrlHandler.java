package com.farmerCalculator.Exchange;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
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

    @SneakyThrows
    public static String getRawData(String url) {
        URLConnection conn = UrlHandler.GetConnection(url);
        CheckCorrectApiResponse(conn);
        InputStream inputStream = conn.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return getDataFromConnection(inputStream, bufferedReader);
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

    private static void CheckCorrectApiResponse(URLConnection connection) {
        HttpURLConnection connectionToCheck = (HttpURLConnection) connection;
        try {
            int code = connectionToCheck.getResponseCode();
            if(code != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Connection to url=[" + connectionToCheck.getURL() +
                        "] failed. Returned error code=[" + code +"].\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
