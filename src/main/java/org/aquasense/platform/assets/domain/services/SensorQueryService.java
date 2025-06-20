package org.aquasense.platform.assets.domain.services;

import org.aquasense.platform.assets.domain.model.aggregates.Sensor;
import org.aquasense.platform.assets.domain.model.queries.GetSensorByIdQuery;
import org.aquasense.platform.iam.domain.model.aggregates.User;
import org.aquasense.platform.iam.domain.model.queries.GetUserByIdQuery;

import java.util.Optional;

public interface SensorQueryService {
    Optional<Sensor> handle(GetSensorByIdQuery query);
}
