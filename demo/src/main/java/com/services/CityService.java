package com.services;

import com.model.City;
import com.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by inastase on 11/24/2016.
 */
@Service
public interface CityService {
    public City save(City city);
    public City findOne(long id);
    public List<City> findAll();
    public void delete(long id);
    //public void delete(long id, String username);
    public City findByCityName(String cityName);
    public City updateJson(String cityName);
}
