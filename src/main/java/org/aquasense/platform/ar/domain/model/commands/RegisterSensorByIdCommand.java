package org.aquasense.platform.ar.domain.model.commands;

public record RegisterSensorByIdCommand(
        String name,
        String description
) {
}
