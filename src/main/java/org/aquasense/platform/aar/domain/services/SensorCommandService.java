package org.aquasense.platform.aar.domain.services;

import org.aquasense.platform.aar.domain.model.aggregates.Sensor;
import org.aquasense.platform.aar.domain.model.commands.CreateSensorCommand;

import java.util.Optional;

public interface SensorCommandService {
    Optional<Sensor> handle(CreateSensorCommand command);
}
