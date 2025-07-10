package org.aquasense.platform.aar.domain.services;

import org.aquasense.platform.aar.domain.model.aggregates.Sensor;
import org.aquasense.platform.aar.domain.model.queries.GetAllSensorsQuery;
import org.aquasense.platform.aar.domain.model.queries.GetSensorByIdQuery;

import java.util.List;
import java.util.Optional;

public interface SensorQueryService {
    Optional<Sensor> handle(GetSensorByIdQuery query);

    List<Sensor> handle(GetAllSensorsQuery query);
}
