package com.services.impl;

import com.model.City;
import com.model.User;
import com.repository.CityRepository;
import com.repository.UserRepository;
import com.services.CityService;
import com.services.UserService;
import com.services.WeatherService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
@Service
@Transactional
/**
 * Created by inastase on 11/24/2016.
 */
public class CityServiceImpl  implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    WeatherService weatherService;

    @Autowired
    UserRepository userRepository;



    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City findOne(long id) {
        return cityRepository.findOne(id);
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public void delete(long id) {
        City deletedCity = cityRepository.findOne(id);
        System.out.println(deletedCity);
        cityRepository.delete(deletedCity);

    }

    @Override
    public City findByCityName(String cityName) {
        return cityRepository.findByCityName(cityName);
    }

    @Override
    public City updateJson(String cityName) {
        City city = findByCityName(cityName);
        Date dateMili = new Date();
        if(city!=null) {
            if (dateMili.getTime() -city.getDate().getTime()  < 5*3600) {
                System.out.println("get from bd");
                city.getJsonWeather();

            }
            else{
                weatherService.jsonParsing(cityName);
                city.setCityName(cityName);
                city.setJsonWeather(weatherService.jsonParsing(cityName).toString());
                city.setDate(new Date());
                this.save(city);
                System.out.println("set from api update");
                city.setJsonWeather(weatherService.jsonParsing(cityName).toString());
            }
        }
        else{
            city = new City();
            weatherService.jsonParsing(cityName);
            city.setCityName(cityName);
            city.setJsonWeather(weatherService.jsonParsing(cityName).toString());
            city.setDate(new Date());
            this.save(city);
            System.out.println("set from api new");
            city.setJsonWeather(weatherService.jsonParsing(cityName).toString());
        }
        return this.save(city);
    }

}
