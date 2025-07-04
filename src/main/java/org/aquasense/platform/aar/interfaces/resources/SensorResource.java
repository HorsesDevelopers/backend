package org.aquasense.platform.aar.interfaces.resources;

import java.time.LocalDateTime;

public record  SensorResource(Long id,
                              int oxygenLevel,
                              //int pHLevel,
                              String sensorType,
                              String status,
                              Float temperatureLevel,
                              LocalDateTime last_update) {
}
