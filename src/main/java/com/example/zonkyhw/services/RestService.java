package com.example.zonkyhw.services;

import com.example.zonkyhw.domain.Loan;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.example.zonkyhw.services.RestUtils.getEntityWithHeaders;

@Component
public class RestService {

    private final RestTemplate rest;

    public RestService(RestTemplate rest) {
        this.rest = rest;
    }

    public ResponseEntity<List<Loan>> doGet(String uriString) {
         return rest.exchange(uriString, HttpMethod.GET, getEntityWithHeaders(), new ParameterizedTypeReference<List<Loan>>(){});
    }

}
