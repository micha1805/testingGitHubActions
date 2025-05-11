package com.example.demo.controller;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    private final Environment environment;
    
    public HelloController(Environment environment) {
        this.environment = environment;
    }
    
    @GetMapping("/")
    public String hello() {
        String activeProfiles = String.join(", ", environment.getActiveProfiles());
        String defaultProfiles = String.join(", ", environment.getDefaultProfiles());
        String appEnv = environment.getProperty("app.environment", "");
        return String.format("Active profiles: %s\nDefault profiles: %s\napp.environment: %s",
            activeProfiles, defaultProfiles, appEnv.trim());
    }
} 