package com.example.demo;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@Component
public class NewsAPI {

    public static final String API_KEY = "986e8e301073426c86d5d6a24e346b67";

    public String topHeadLines(final String country, final String category, final String source, final String query) {
        try {
            StringBuilder url = new StringBuilder("https://newsapi.org/v2/top-headlines?");
            if(country!=null){
                url.append("country=");
                url.append(country);
            }
            if(category!=null){
                url.append("&category=");
                url.append(category);
            }
            if(source!=null){
                url.append("&source=");
                url.append(source);
            }
            if(query!=null){
                url.append("&q=");
                url.append(query);
            }
            url.append("&apiKey=");
            url.append(API_KEY);
            URL obj = new URL(url.toString());
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }

    public String searchNews(@NonNull final String query) {
        try {
            StringBuilder url = new StringBuilder("https://newsapi.org/v2/everything?q=");
            url.append(query);
            url.append("&apiKey=");
            url.append(API_KEY);
            URL obj = new URL(url.toString());
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }

    public String searchSources(final String country, final String category, final String source, final String language) {
        try {
            StringBuilder url = new StringBuilder("https://newsapi.org/v2/sources?");
            if(country!=null){
                url.append("country=");
                url.append(country);
            }
            if(category!=null){
                url.append("&category=");
                url.append(category);
            }
            if(source!=null){
                url.append("&source=");
                url.append(source);
            }
            if(language!=null){
                url.append("&language=");
                url.append(language);
            }
            url.append("&apiKey=");
            url.append(API_KEY);
            URL obj = new URL(url.toString());
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }
}