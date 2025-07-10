package org.aquasense.platform.ar.interfaces.resources;

public record CreateSensorResource(Long id,
                                   int oxygenLevel,
                                   //int pHLevel,
                                   String sensorType,
                                   String status,
                                   Float temperatureLevel) {
}
