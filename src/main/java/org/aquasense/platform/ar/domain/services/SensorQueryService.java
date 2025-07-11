package org.aquasense.platform.ar.domain.services;

import org.aquasense.platform.ar.domain.model.entities.Sensor;
import org.aquasense.platform.ar.domain.model.queries.ExistSensorByPondIdAndTypeQuery;
import org.aquasense.platform.ar.domain.model.queries.GetAllSensorsQuery;
import org.aquasense.platform.ar.domain.model.queries.GetSensorByIdQuery;
import org.aquasense.platform.ar.domain.model.queries.GetSensorIdByPondIdAndTypeQuery;

import java.util.List;
import java.util.Optional;

public interface SensorQueryService {
    Optional<Sensor> handle(GetSensorByIdQuery query);
    boolean handle(ExistSensorByPondIdAndTypeQuery query);
    long handle(GetSensorIdByPondIdAndTypeQuery query);
    List<Sensor> handle(GetAllSensorsQuery query);
}
