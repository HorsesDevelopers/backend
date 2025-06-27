package org.aquasense.platform.operationandmonitoring.interfaces.rest.resources;



public record PondResource(
        Long id,
        String ubication,
        String name,
        String waterType,
        Double volume,
        Double area,
        String createdAt
) {
}
