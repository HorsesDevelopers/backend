package org.aquasense.platform.assets.interfaces.acl;

import org.aquasense.platform.assets.domain.model.aggregates.Sensor;
import org.aquasense.platform.assets.domain.model.queries.GetAllSensorsQuery;
import org.aquasense.platform.assets.domain.model.queries.GetSensorsByDateRange;
import org.aquasense.platform.assets.domain.services.SensorCommandService;
import org.aquasense.platform.assets.domain.services.SensorQueryService;

import java.time.LocalDateTime;
import java.util.List;

public class SensorFacade {

    private final SensorQueryService sensorQueryService;
    private final SensorCommandService sensorCommandService;

    public SensorFacade(SensorQueryService sensorQueryService, SensorCommandService sensorCommandService) {
        this.sensorQueryService = sensorQueryService;
        this.sensorCommandService = sensorCommandService;
    }

    public List<Sensor> getSensorsByDateRange(LocalDateTime start, LocalDateTime end) {
        return sensorQueryService.handle(new GetSensorsByDateRange(start, end));
    }

    public List<Sensor> getAllSensors() {
        return sensorQueryService.handle(new GetAllSensorsQuery());
    }
}
