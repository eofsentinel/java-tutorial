package com.eofsentinel.simpleSpringBootWebApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String greet() {
        return "Welcome to Spring Boot Web App!!";
    }

    @RequestMapping("/about")
    public String about() {
        return "This project is done by EOF Sentinel!";
    }
}
