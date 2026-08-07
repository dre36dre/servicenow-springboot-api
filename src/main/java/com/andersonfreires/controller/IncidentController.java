package com.andersonfreires.controller;

import model.Incident;
import com.andersonfreires.service.ServiceNowClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class IncidentController {

    private final ServiceNowClient serviceNowClient;

    public IncidentController(ServiceNowClient serviceNowClient) {
        this.serviceNowClient = serviceNowClient;
    }

    // GET - List incidents
    @GetMapping("/incidents")
    public String getIncidents() {
        return serviceNowClient.getIncidents();
    }

    
    // POST - Create a new incident
    @PostMapping("/incidents")
    public String createIncident(@RequestBody Incident incident) {
        return serviceNowClient.createIncident(incident);
    }
    
    @PutMapping("/incidents/{sysId}")
    public String updateIncident(
            @PathVariable String sysId,
            @RequestBody Incident incident) {

        return serviceNowClient.updateIncident(sysId, incident);
    }
    
 // DELETE - Delete an incident
    @DeleteMapping("/incidents/{sysId}")
    public String deleteIncident(@PathVariable String sysId) {

        return serviceNowClient.deleteIncident(sysId);
    }
    
}