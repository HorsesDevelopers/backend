package org.aquasense.platform.oam.interfaces.rest.resources;

public record CreateNotificationResource(String title, String description) {
    public CreateNotificationResource {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("title is required");
        if (description == null || description.isBlank()) throw new IllegalArgumentException("description is required");
    }
}
