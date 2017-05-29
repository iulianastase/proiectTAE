package com.services;

import com.model.City;
import com.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by inastase on 11/24/2016.
 */
@Service
public interface UserService {
    public User save(User user);
    public User findOne(long id);
    public List<User> findAll();
    public User delete(long id);
    //public void deleteCity(String username, String cityName);
    //public void delete (long id, String username);
    public User findByName(String name);
    public User updateCities(City cityName, String name);
    public boolean verify(String username, String password);
}
