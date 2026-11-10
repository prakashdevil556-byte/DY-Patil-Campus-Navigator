package com.campus.navigation.model;

public record Location(
        String id,
        String name,
        String shortName,
        String category,
        String categoryBadge,
        String description,
        String departments,
        String image,
        String building,
        String floors,
        String labs,
        String facilities,
        int x,
        int y,
        int floor
) {}
