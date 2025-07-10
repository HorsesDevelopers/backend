package org.aquasense.platform.ar.interfaces.acl;

import org.aquasense.platform.ar.domain.model.commands.CreateSensorCommand;
import org.aquasense.platform.ar.domain.model.queries.ExistSensorByPondIdAndTypeQuery;
import org.aquasense.platform.ar.domain.model.queries.GetSensorIdByPondIdAndTypeQuery;
import org.aquasense.platform.ar.domain.services.SensorCommandService;
import org.aquasense.platform.ar.domain.services.SensorQueryService;
import org.springframework.stereotype.Service;

@Service
public class ARContextFacade {

    private final SensorCommandService sensorCommandService;
    private final SensorQueryService sensorQueryService;

    public ARContextFacade(SensorCommandService sensorCommandService, SensorQueryService sensorQueryService) {
        this.sensorCommandService = sensorCommandService;
        this.sensorQueryService = sensorQueryService;
    }

    public long createSensor(
            Long pondId,
            String type,
            float maxValue,
            float minValue
    ) {
        var command = new CreateSensorCommand(
                pondId,
                type,
                maxValue,
                minValue
        );
        var sensor = sensorCommandService.handle(command);
        return sensor.get().getId();
    }

    public boolean existSensorByPondIdAndType(Long pondId, String type) {
        return sensorQueryService.handle(new ExistSensorByPondIdAndTypeQuery(pondId, type));
    }

    public long getSensorIdByPondIdAndType(Long pondId, String type) {
        return sensorQueryService.handle(new GetSensorIdByPondIdAndTypeQuery(pondId, type));
    }
}
