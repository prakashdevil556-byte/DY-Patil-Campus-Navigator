package com.campus.navigation.controller;

import com.campus.navigation.model.Location;
import com.campus.navigation.model.RouteResponse;
import com.campus.navigation.service.CampusService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CampusController {
    private final CampusService campusService;
    public CampusController(CampusService campusService) { this.campusService = campusService; }

    @GetMapping("/locations")
    public List<Location> getLocations() { return campusService.getLocations(); }

    @GetMapping("/route")
    public RouteResponse getRoute(@RequestParam String from, @RequestParam String to) {
        try { return campusService.findShortestRoute(from, to); }
        catch (IllegalArgumentException ex) { throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage()); }
    }

    @GetMapping("/health")
    public Map<String, String> health() { return Map.of("status", "UP", "application", "DY Patil Campus Navigator"); }
}
