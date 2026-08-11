package com.andersonfreires.controller;

import model.Incident;
import com.andersonfreires.service.ServiceNowClient;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IncidentController {

    private final ServiceNowClient serviceNowClient;

    public IncidentController(ServiceNowClient serviceNowClient) {
        this.serviceNowClient = serviceNowClient;
    }

    // GET - List incidents
    @GetMapping("/incidents")
    public ResponseEntity<String> getIncidents() {

        String response =
                serviceNowClient.getIncidents();

        return ResponseEntity.ok(response);
    }

    
    // POST - Create a new incident
    @PostMapping("/incidents")
    public ResponseEntity<String> createIncident(
            @RequestBody Incident incident) {

        String response =
                serviceNowClient.createIncident(incident);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
    
    @PutMapping("/incidents/{sysId}")
    public ResponseEntity<String> updateIncident(
            @PathVariable String sysId,
            @RequestBody Incident incident) {

        String response =
                serviceNowClient.updateIncident(sysId, incident);

        return ResponseEntity.ok(response);
    }
    
 // DELETE - Delete an incident
    @DeleteMapping("/incidents/{sysId}")
    public ResponseEntity<Void> deleteIncident(
            @PathVariable String sysId) {

        serviceNowClient.deleteIncident(sysId);

        return ResponseEntity.noContent().build();
    }
    
}