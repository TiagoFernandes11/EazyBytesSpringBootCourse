package com.udemy.SimpleSpringWebApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String displayHelloPage(){
        return "home.html";
    }
}
