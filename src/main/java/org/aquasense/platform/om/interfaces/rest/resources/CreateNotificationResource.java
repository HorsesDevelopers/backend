package org.aquasense.platform.om.interfaces.rest.resources;

public record CreateNotificationResource(
        String title,
        String description,
        Long pondId
) {
    public CreateNotificationResource {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("title is required");
        if (description == null || description.isBlank()) throw new IllegalArgumentException("description is required");
    }
}
