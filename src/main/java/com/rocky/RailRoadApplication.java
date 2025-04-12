package com.rocky;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RailRoadApplication {

    private static final Logger logger = LoggerFactory.getLogger(RailRoadApplication.class);


    public static void main(String[] args) {
            logger.info("Starting RailRoad Application...");
            SpringApplication.run(RailRoadApplication.class, args);
    }
}
