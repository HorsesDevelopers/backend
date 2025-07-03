package org.aquasense.platform.assets.domain.services;

import org.aquasense.platform.assets.domain.model.aggregates.Sensor;
import org.aquasense.platform.assets.domain.model.commands.CreateSensorCommand;
import org.aquasense.platform.assets.domain.model.queries.GetSensorsByDateRange;

import java.util.List;
import java.util.Optional;

public interface SensorCommandService {
    Optional<Sensor> handle(CreateSensorCommand command);
}
