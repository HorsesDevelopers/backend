package org.aquasense.platform.assets.domain.model.commands;

public record CreateSensorCommand(int oxygen_level,
                                  int pH_level,
                                  int water_temp_level) {
}
