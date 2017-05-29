package com.controllers;

import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by inastase on 5/29/2017.
 */
@Controller
public class ThymeleafController {

    @RequestMapping(value = "/presentation", method = RequestMethod.GET)
    public String presentation (HttpServletRequest request, Model model){
        String text = request.getParameter("hello");

        model.addAttribute("message", text);

        return "presentation";
    }
}
