package com.github.jbarseg.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class SpringController {

    @GetMapping("/hi")
    public String greet(){
        return "Say Hi!";
    }
}
