package com.model;

import java.util.Date;

/**
 * Created by inastase on 11/23/2016.
 */
public class WeatherDay {
    private float temperature;
    private String date;
    WeatherDetails weatherDetails;

    public WeatherDay() {
    }

    public WeatherDay(float temperature, String date, WeatherDetails weatherDetails) {
        this.temperature = temperature;
        this.date = date;
        this.weatherDetails = weatherDetails;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public WeatherDetails getWeatherDetails() {
        return weatherDetails;
    }

    public void setWeatherDetails(WeatherDetails weatherDetails) {
        this.weatherDetails = weatherDetails;
    }

    @Override
    public String toString() {
        return "WeatherDay{" +
                "temperature=" + temperature +
                " C, date='" + date + '\'' +
                ", weatherDetails=" + weatherDetails +
                '}'
                + '\n';
    }
}
