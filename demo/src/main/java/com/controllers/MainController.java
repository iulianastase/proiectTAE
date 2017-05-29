package com.controllers;

import com.model.User;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by inastase on 11/24/2016.
 */
@RestController
public class MainController {

    @Autowired
    UserService userService;
        @RequestMapping(value = "/loginPage", method = RequestMethod.POST)
    public String login(@RequestBody User user){
        if(userService.verify(user.getUsername(), user.getPassword())) {
            return "true";
        }
        else{
        return "false";
        }
    }

}
