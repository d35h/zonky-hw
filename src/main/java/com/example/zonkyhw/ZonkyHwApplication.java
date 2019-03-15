package com.example.zonkyhw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties
@EnableScheduling
public class ZonkyHwApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZonkyHwApplication.class, args);
	}

}
