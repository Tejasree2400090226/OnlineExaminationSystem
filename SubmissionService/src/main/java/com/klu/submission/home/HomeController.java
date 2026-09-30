package com.klu.submission.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to Online Examination Submission Service | "
             + "This service manages student exam submissions.";
    }
}