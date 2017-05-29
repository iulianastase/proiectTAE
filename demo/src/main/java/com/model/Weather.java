package com.model;

import java.util.List;

/**
 * Created by inastase on 11/22/2016.
 */
public class Weather {
    private String cityName;
    private String country;
    List<WeatherDay> forecast;

    public Weather(String cityName, String country, List<WeatherDay> forecast) {
        this.cityName = cityName;
        this.country = country;
        this.forecast = forecast;
    }

    public Weather() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<WeatherDay> getForecast() {
        return forecast;
    }

    public void setForecast(List<WeatherDay> forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "cityName='" + cityName + '\'' +
                ", country='" + country + '\'' +
                ", forecast=" + forecast +
                '}'+
                '\n';
    }
}
