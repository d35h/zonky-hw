package com.example.zonkyhw.enums;

public enum ZonkyQueryParams {

    DATE_LOAN_PUBLISHED_GT_PARAM("datePublished__gt");

    private String queryParam;

    public String getQueryParam() {
        return this.queryParam;
    }

    ZonkyQueryParams(String queryParam) {
        this.queryParam = queryParam;
    }

}
