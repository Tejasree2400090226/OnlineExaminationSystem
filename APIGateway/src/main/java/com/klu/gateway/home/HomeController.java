package com.klu.gateway.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to Online Examination API Gateway | "
             + "This gateway routes requests to the examination microservices.";
    }
}