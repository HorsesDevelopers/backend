package org.aquasense.platform.ar.interfaces.resources;

import java.time.LocalDateTime;

public record  SensorResource(
        Long id,
        String type,
        float maxValue,
        float minValue
) {
}
