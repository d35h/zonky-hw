package com.example.zonkyhw.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

public class RestUtils {

    public static String getUriStringWithParams(String url, MultiValueMap<String, String> queryParams) {
        return UriComponentsBuilder.fromHttpUrl(url)
                .queryParams(queryParams)
                .build()
                .toUriString();
    }

    public static HttpEntity<HttpHeaders> getEntityWithHeaders() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("User-Agent", "zaru/1.0 (www.indevelopment.com)");
        requestHeaders.set("X-Page", "0");
        requestHeaders.set("X-Set", "10");

        return new HttpEntity<>(requestHeaders);
    }
}

