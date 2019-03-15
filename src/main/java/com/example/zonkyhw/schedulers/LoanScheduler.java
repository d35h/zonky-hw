package com.example.zonkyhw.schedulers;

import com.example.zonkyhw.configuration.rest.ZonkyApiConfiguration;
import com.example.zonkyhw.domain.Loan;
import com.example.zonkyhw.services.RestService;
import org.springframework.http.HttpEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.example.zonkyhw.enums.ZonkyQueryParams.DATE_LOAN_PUBLISHED_GT_PARAM;
import static com.example.zonkyhw.services.RestUtils.getUriStringWithParams;

@Component
public class LoanScheduler {

    private final RestService rest;
    private final ZonkyApiConfiguration configuration;
    private final static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
    private String processingDate = "";

    public LoanScheduler(RestService restService, ZonkyApiConfiguration configuration) {
        this.rest = restService;
        this.configuration = configuration;
    }

    @Scheduled(cron = "0 */5 * * * *")
    public void lookForLoans() {
        System.out.println(processingDate.isEmpty() ? "Processing for the first time" : "Processing for the date: " + processingDate);
        HttpEntity<List<Loan>> result = rest.doGet(getUriStringWithParams(configuration.getUrl(), getDateParams(processingDate)));
        System.out.println("Done...");
        processResult(result);
    }

    private void processResult(HttpEntity<List<Loan>> result) {
        System.out.println("Result is:");
        if (result.getBody() != null && !result.getBody().isEmpty()) {
            List<Loan> loans = result.getBody();
            printLoans(loans);
            processingDate = formatter.format(getLatestPublishedDate(loans));
        }
    }

    private Date getLatestPublishedDate(List<Loan> loans) {
        return loans.stream()
                .map(Loan::getDatePublished)
                .max(Date::compareTo)
                .orElseThrow(IllegalStateException::new);
    }

    private void printLoans(List<Loan> loans) {
        loans.forEach(System.out::println);
    }

    private MultiValueMap<String, String> getDateParams(String date) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add(DATE_LOAN_PUBLISHED_GT_PARAM.getQueryParam(), date);

        return params;
    }

}