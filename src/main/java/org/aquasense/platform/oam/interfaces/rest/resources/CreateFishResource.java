package org.aquasense.platform.oam.interfaces.rest.resources;

public record CreateFishResource(String type, Integer quantity, Long pondId) {
    public CreateFishResource {
        if (type == null || type.isEmpty()) throw new IllegalArgumentException("type is required");
        if (quantity == null || quantity <= 0) throw new IllegalArgumentException("quantity must be greater than 0");
        if (pondId == null || pondId <= 0) throw new IllegalArgumentException("pondId must be greater than 0");
    }
}
