package com.example.zonkyhw.configuration.rest;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestTemplateConfiguration {

    private final ZonkyApiConfiguration configuration;

    public RestTemplateConfiguration(ZonkyApiConfiguration configuration) {
        this.configuration = configuration;
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofSeconds(configuration.getSecondsConnectTimeOut()))
                .setReadTimeout(Duration.ofSeconds(configuration.getSecondsReadTimeOut()))
                .build();
    }

}
