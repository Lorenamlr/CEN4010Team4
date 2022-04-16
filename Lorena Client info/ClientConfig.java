package com.example.demo.client;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClientConfig {

    @Bean
    CommandLineRunner commandLineRunner(ClientRepository repository) {
        return args -> {
             Client lorena = new Client(
                    1L,
                    "Lorena",
                    "Miranda",
                    "lorena@fiu.edu",
                    "Female"
            );

             Client fernando = new Client(
                     1l,
                     "Fernando",
                     "Collante",
                     "fernando@fiu.edu",
                     "Male"

             );

             repository.saveAll(
            List.of(lorena, fernando)
             );
                           };
    }
}
