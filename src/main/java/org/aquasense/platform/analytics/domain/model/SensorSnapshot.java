package org.aquasense.platform.analytics.domain.model;

import java.time.LocalDateTime;

public record SensorSnapshot(int oxygenLevel,
                             Float waterTempLevel,
                             String sensorType,
                             String status,
                             LocalDateTime lastUpdate) {
}
