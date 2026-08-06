package com.andersonfreires.service;

import model.Incident;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
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

    // GET - List incidents
    public String getIncidents() {

        return restClient.get()
                .uri("/api/now/table/incident")
                .retrieve()
                .body(String.class);
    }

    // POST - Create a new incident
    public String createIncident(Incident incident) {

        return restClient.post()
                .uri("/api/now/table/incident")
                .contentType(MediaType.APPLICATION_JSON)
                .body(incident)
                .retrieve()
                .body(String.class);
    }
}