package org.aquasense.platform.operationandmonitoring.interfaces.rest.resources;

public record FishResource(
        Long id,
        String type,
        Integer quantity,
        Long pondId,
        String createdAt) {
}
