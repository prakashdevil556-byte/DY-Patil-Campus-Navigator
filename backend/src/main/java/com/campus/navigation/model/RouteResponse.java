package com.campus.navigation.model;

import java.util.List;

public record RouteResponse(List<Location> path, int distanceMeters, String message) {}
