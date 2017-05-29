package com.services.impl;

import com.model.Weather;
import com.model.WeatherDay;
import com.model.WeatherDetails;
import com.services.WeatherService;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by inastase on 11/22/2016.
 */
@Service
@Transactional
public class WeatherServiceImpl implements WeatherService{
    private static String apiKey ="5dc7e07252027b122e5643a00b876bc3";
    @Override
    public String urlConstruction(String city){
        String url = "http://api.openweathermap.org/data/2.5/forecast?q=";
        url += city;
        url += "&units=metric&mode=json&appid=";
        url += apiKey;

        return url;
    }
    //citire json,
    @Override
    public  String readAll(Reader reader) {
        StringBuilder sb = new StringBuilder();
        int i;
        try {
            while ((i = reader.read()) != -1) {
                sb.append((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    //citire json from url,
    @Override
    public JSONObject readJsonFromUrl(String url){
        InputStream is = null;
        try {
            is = new URL(url).openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(br);
            JSONObject json = new JSONObject(jsonText);

            return json;
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getJson(String city) {
        JSONObject json = readJsonFromUrl(urlConstruction(city));
        return json.toString();
    }

    @Override
    public Weather jsonParsing(String cityName) {
        JSONObject json = readJsonFromUrl(urlConstruction(cityName));

        WeatherDay weatherDay = new WeatherDay();
        weatherDay.setDate("");

        List<WeatherDay> forecast = new ArrayList<>();
        Weather weather1 = new Weather();
        weather1.setCityName((String) json.getJSONObject("city").get("name"));
        weather1.setCountry((String) json.getJSONObject("city").get("country"));
        for(int i = 0; i < json.getJSONArray("list").length(); i++){
            WeatherDay weatherDay1 = new WeatherDay();
            weatherDay1.setDate((String) json.getJSONArray("list").getJSONObject(i).get("dt_txt"));
            WeatherDetails weatherDetails = new WeatherDetails();
            if(!weatherDay1.getDate().equals(weatherDay.getDate())){
                weatherDay1.setTemperature(Float.parseFloat(json.getJSONArray("list").getJSONObject(i).getJSONObject("main").get("temp").toString()));
                weatherDetails.setPrecipitation((String) json.getJSONArray("list").getJSONObject(i).getJSONArray("weather").getJSONObject(0).get("main").toString());
                weatherDetails.setDescription((String) json.getJSONArray("list").getJSONObject(i).getJSONArray("weather").getJSONObject(0).get("description").toString());
                weatherDay1.setDate((String) json.getJSONArray("list").getJSONObject(i).get("dt_txt"));
                weatherDay1.setWeatherDetails(weatherDetails);
                forecast.add(weatherDay1);
                weather1.setForecast(forecast);
            }
        }

        return weather1;
    }
}