package org.aquasense.platform.assets.application.queryservices;

import org.aquasense.platform.assets.domain.model.aggregates.Sensor;
import org.aquasense.platform.assets.domain.model.queries.GetSensorByIdQuery;
import org.aquasense.platform.assets.domain.model.queries.GetSensorsByDateRange;
import org.aquasense.platform.assets.domain.services.SensorQueryService;
import org.aquasense.platform.assets.infrastructure.persistence.jpa.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        return this.sensorRepository.findById(query.id());
    }

    @Override
    public List<Sensor> handle(GetSensorsByDateRange query) {
        return this.sensorRepository.findAllByLastUpdateBetween(query.start(), query.end());
    }


}
