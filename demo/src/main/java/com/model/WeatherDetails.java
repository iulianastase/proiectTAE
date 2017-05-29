package com.model;

/**
 * Created by inastase on 11/23/2016.
 */
public class WeatherDetails {
    private String precipitation;
    private String description;

    public WeatherDetails(String precipitation, String description) {
        this.precipitation = precipitation;
        this.description = description;
    }

    public WeatherDetails() {
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "WeatherDetails{" +
                "precipitation='" + precipitation + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
