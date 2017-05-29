package com.services.impl;

import com.model.City;
import com.model.User;
import com.repository.CityRepository;
import com.repository.UserRepository;
import com.services.UserService;
import com.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by inastase on 11/24/2016.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    WeatherService weatherService;
    @Autowired
    CityRepository cityRepository;
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findOne(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User delete(long id) {
        User deletedUser = userRepository.findOne(id);
        userRepository.delete(deletedUser);

        return deletedUser;
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User updateCities(City cityName, String name) {
        User user = userRepository.findByName(name);
        City cityAdd = new City();
        int ok = 0;
        for( int i = 0; i <user.getCities().size(); i++) {
            if (cityRepository.findByCityName(cityName.getCityName()) != null) {
                System.out.println("if");
//                user.getCities().add(cityName);
//                userRepository.save(user);
//                return null;

            }

        }

            System.out.println("else");
            cityAdd.setCityName(cityName.getCityName());
            cityAdd.setJsonWeather((weatherService.jsonParsing(cityName.getCityName())).toString());
            cityAdd.setDate(new Date());
            user.getCities().add(cityAdd);

            System.out.println("save");
            userRepository.save(user);

            return user;
    }

    @Override
    public boolean verify(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if(user != null){
            return username.equals(user.getUsername()) && password.equals(user.getPassword());
        }
            return false;
    }
}
