package com.andersonfreires.controller;

import com.andersonfreires.service.ServiceNowClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncidentController {

    private final ServiceNowClient serviceNowClient;

    public IncidentController(ServiceNowClient serviceNowClient) {
        this.serviceNowClient = serviceNowClient;
    }

    @GetMapping("/incidents")
    public String getIncidents() {
        return serviceNowClient.getIncidents();
    }
}