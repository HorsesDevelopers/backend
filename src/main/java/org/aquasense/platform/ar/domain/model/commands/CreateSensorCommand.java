package org.aquasense.platform.ar.domain.model.commands;

import org.aquasense.platform.ar.domain.model.valueobjects.DeviceStatus;

public record CreateSensorCommand(
        Long pondId,
        String type,
        float maxValue,
        float minValue
) {
}
