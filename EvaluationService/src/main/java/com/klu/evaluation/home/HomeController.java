package com.klu.evaluation.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to Online Examination Evaluation Service | "
             + "This service manages evaluation results, including submission ID, score, and result status.";
    }
}