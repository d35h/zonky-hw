package com.example.zonkyhw.configuration.rest;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix="zonky")
@Getter
@Setter
public class ZonkyApiConfiguration {

    private String url = "https://api.zonky.cz/loans/marketplace";
    private int secondsConnectTimeOut = 120;
    private int secondsReadTimeOut = 120;

}