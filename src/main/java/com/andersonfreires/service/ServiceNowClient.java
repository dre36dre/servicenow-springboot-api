package com.andersonfreires.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ServiceNowClient {

    private final RestClient restClient;


    public ServiceNowClient(
            @Value("${servicenow.url}") String baseUrl,
            @Value("${servicenow.username}") String username,
            @Value("${servicenow.password}") String password) {

        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .defaultHeaders(headers ->
                        headers.setBasicAuth(username, password))
                .build();
    }
    
    public String getIncidents() {

        return restClient.get()
                .uri("/api/now/table/incident")
                .retrieve()
                .body(String.class);
    }
    
}