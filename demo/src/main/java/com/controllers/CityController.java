package com.controllers;

import com.model.City;
import com.model.User;
import com.model.Weather;
import com.services.CityService;
import com.services.UserService;
import com.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by inastase on 11/25/2016.
 */
@RestController
@RequestMapping(value = "/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    WeatherService weatherService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/{cityName}", method = RequestMethod.GET)
    public Weather getCityForecast(@PathVariable String cityName){
        cityService.updateJson(cityName);
        return weatherService.jsonParsing(cityName);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCity(@PathVariable Long id){
         cityService.delete(id);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public List<City> updateCity(@PathVariable String name){
        User user = userService.findByName(name);
        return user.getCities();
    }


}
