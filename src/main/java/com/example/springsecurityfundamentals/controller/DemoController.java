package com.example.springsecurityfundamentals.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Paavan Shah on 19-06-2023.
 */
@RestController
public class DemoController {

    @GetMapping("/greetings")
    public String greeting(){
        return "Welcome!";
    }

}
