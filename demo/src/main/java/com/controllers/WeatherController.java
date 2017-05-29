package com.controllers;

import com.model.Weather;
import com.repository.CityRepository;
import com.services.CityService;
import com.services.WeatherService;
import com.services.impl.WeatherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by inastase on 11/22/2016.
 */
@RestController
@RequestMapping(value = "/weather")
public class WeatherController {

    @Autowired
    private CityService cityService;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private WeatherService weatherService;

    @RequestMapping(value = "/{cityName}", method = RequestMethod.GET)
    public Weather getForecast(@PathVariable String cityName){
        Weather weather = null;
        weather = weatherService.jsonParsing(cityName);
        return weather;
    }

    @RequestMapping(value = "/{cityName}", method = RequestMethod.PUT)
    public void saveForecast(@PathVariable String cityName){

    }


}
