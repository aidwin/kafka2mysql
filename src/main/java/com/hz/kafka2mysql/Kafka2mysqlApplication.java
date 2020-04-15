package com.hz.kafka2mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Kafka2mysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(Kafka2mysqlApplication.class, args);
    }
}
