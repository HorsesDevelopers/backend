package org.aquasense.platform.aar.domain.model.commands;

public record CreateSensorCommand(int oxygen_level,
                                  String sensor_type,
                                  String status,
                                  Float water_temp_level) {
}
