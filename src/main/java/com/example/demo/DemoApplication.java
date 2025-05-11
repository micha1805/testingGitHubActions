package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class DemoApplication {
    
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
    
    private final Environment environment;
    
    public DemoApplication(Environment environment) {
        this.environment = environment;
    }
    
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    
    @EventListener(ApplicationStartedEvent.class)
    public void logStartup() {
        logger.info("Active profiles: {}", String.join(", ", environment.getActiveProfiles()));
        logger.info("Default profiles: {}", String.join(", ", environment.getDefaultProfiles()));
        logger.info("app.environment value: {}", environment.getProperty("app.environment"));
    }
} 