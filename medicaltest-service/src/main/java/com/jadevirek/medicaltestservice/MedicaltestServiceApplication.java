package com.jadevirek.medicaltestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MedicaltestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicaltestServiceApplication.class, args);
    }

}
