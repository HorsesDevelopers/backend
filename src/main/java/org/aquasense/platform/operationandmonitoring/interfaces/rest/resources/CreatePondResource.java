package org.aquasense.platform.operationandmonitoring.interfaces.rest.resources;

public record CreatePondResource(
        String ubication,
        String name
) {
    public CreatePondResource {
        if (ubication == null || ubication.isBlank()) throw new IllegalArgumentException("ubication is required");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name is required");
    }

}
