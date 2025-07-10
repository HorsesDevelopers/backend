package org.aquasense.platform.om.interfaces.rest.resources;


import java.util.List;

public record PondResource(
        Long id,
        String ubication,
        String name,
        String waterType,
        List<FishResource> fishes,
        Double volume,
        Double area,
        String createdAt
) {
}
