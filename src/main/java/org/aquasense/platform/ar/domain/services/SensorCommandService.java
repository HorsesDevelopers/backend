package org.aquasense.platform.ar.domain.services;

import org.aquasense.platform.ar.domain.model.entities.Sensor;
import org.aquasense.platform.ar.domain.model.commands.CreateSensorCommand;

import java.util.Optional;

public interface SensorCommandService {
    Optional<Sensor> handle(CreateSensorCommand command);
}
