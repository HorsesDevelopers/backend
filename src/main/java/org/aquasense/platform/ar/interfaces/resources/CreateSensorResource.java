package org.aquasense.platform.ar.interfaces.resources;

public record CreateSensorResource(
        Long pondId,
        String type,
        float maxValue,
        float minValue
) {
}
