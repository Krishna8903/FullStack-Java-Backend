package com.example.WareWing.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner init() {

        return args -> {

            System.out.println(
                    "WareWing Started");
        };
    }
}