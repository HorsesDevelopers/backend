package org.aquasense.platform.assets.interfaces.resources;

public record CreateSensorResource(
                                   int oxygenLevel,
                                   int pHLevel,
                                   int temperatureLevel) {
}
