package com.klu.exam.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to Online Examination Exam Service | "
             + "This service manages exams, including title, duration, and total marks.";
    }
}