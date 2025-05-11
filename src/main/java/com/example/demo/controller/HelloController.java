package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @Value("${app.environment}")
    private String environment;
    
    @GetMapping("/")
    public String hello() {
        return String.format("Hello from %s environment!", environment.trim());
    }
} 