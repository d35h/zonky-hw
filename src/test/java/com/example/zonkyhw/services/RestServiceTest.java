package com.example.zonkyhw.services;

import com.example.zonkyhw.domain.Loan;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.example.zonkyhw.services.RestUtils.getEntityWithHeaders;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.ACCEPTED;

@RunWith(MockitoJUnitRunner.class)
public class RestServiceTest {

    @Mock
    private RestTemplate template;

    @InjectMocks
    private RestService service;

    private final static ResponseEntity<List<Loan>> EXPECTED = new ResponseEntity<>(new ArrayList<>(), ACCEPTED);

    @Before
    public void setUp() {
        when(template.exchange(eq("https://zonky.cz"), eq(HttpMethod.GET), eq(getEntityWithHeaders()), any(ParameterizedTypeReference.class))).thenReturn(EXPECTED);
    }

    @Test
    public void shouldReturnObject() {
        String url = "https://zonky.cz";
        ResponseEntity<List<Loan>> result = service.doGet(url);
        verify(template).exchange(eq(url), eq(HttpMethod.GET), eq(getEntityWithHeaders()), any(ParameterizedTypeReference.class));
        verifyNoMoreInteractions(template);
        assertThat(EXPECTED, is(result));
    }

}
