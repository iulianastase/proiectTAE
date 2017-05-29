package com.controllers;

import com.model.City;
import com.model.User;
import com.services.UserService;
import com.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by inastase on 11/25/2016.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    public List<User> getUsers(){
        return userService.findAll();
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.PUT)
    public List<City> updateUserCity(@RequestBody City city,@PathVariable String name){
        System.out.println(city);
        userService.updateCities(city, name);
        User user = userService.findByName(name);
        return user.getCities();
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.PUT)
    public User addUser(@RequestBody User newUser){
        System.out.println(newUser);
        userService.save(newUser);
        User user = userService.findByName(newUser.getName());
        return user;
    }


}
