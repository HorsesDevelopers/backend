package org.aquasense.platform.om.interfaces.rest.resources;

public record FishResource(
        Long id,
        String type,
        Integer quantity,
        Long pondId,
        String createdAt) {
}
