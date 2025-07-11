package org.aquasense.platform.ar.application.queryservices;

import org.aquasense.platform.ar.domain.model.entities.Sensor;
import org.aquasense.platform.ar.domain.model.queries.ExistSensorByPondIdAndTypeQuery;
import org.aquasense.platform.ar.domain.model.queries.GetAllSensorsQuery;
import org.aquasense.platform.ar.domain.model.queries.GetSensorByIdQuery;
import org.aquasense.platform.ar.domain.model.queries.GetSensorIdByPondIdAndTypeQuery;
import org.aquasense.platform.ar.domain.model.valueobjects.SensorType;
import org.aquasense.platform.ar.domain.services.SensorQueryService;
import org.aquasense.platform.ar.infrastructure.persistence.jpa.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorQueryServiceImpl implements SensorQueryService {
    private final SensorRepository sensorRepository;

    public SensorQueryServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }
    @Override
    public Optional<Sensor> handle(GetSensorByIdQuery query) {
        return this.sensorRepository.findById(query.sensorId());
    }

    @Override
    public boolean handle(ExistSensorByPondIdAndTypeQuery query) {
        var type = SensorType.valueOf(query.sensorType());
        return sensorRepository.existsSensorByPondIdAndType(query.pondId(), type);
    }

    @Override
    public long handle(GetSensorIdByPondIdAndTypeQuery query) {
        var type = SensorType.valueOf(query.sensorType());
        var sensor = sensorRepository.getSensorByPondIdAndType(query.pondId(), type);
        return sensor.get().getId();
    }

    @Override
    public List<Sensor> handle(GetAllSensorsQuery query) {
        return this.sensorRepository.findAll();
    }
}
