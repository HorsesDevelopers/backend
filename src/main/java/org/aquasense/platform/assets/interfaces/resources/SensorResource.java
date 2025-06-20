package org.aquasense.platform.assets.interfaces.resources;

import java.time.LocalDateTime;

public record  SensorResource(Long id,
                              int oxygenLevel,
                              int pHLevel,
                              int temperatureLevel,
                              LocalDateTime lastUpdate) {
}
