package org.aquasense.platform.oam.interfaces.rest.resources;

public record CreatePondResource(
        String ubication,
        String name,
        String waterType,
        Double volume,
        Double area
) {
    public CreatePondResource {
        if (ubication == null || ubication.isBlank()) throw new IllegalArgumentException("ubication is required");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name is required");
        if (waterType == null || waterType.isBlank()) throw new IllegalArgumentException("waterType is required");
        if (volume == null || volume <= 0) throw new IllegalArgumentException("volume must be greater than 0");
        if (area == null || area <= 0) throw new IllegalArgumentException("area must be greater than 0");
    }

}
