package org.aquasense.platform.assets.application.commandservices;

import org.aquasense.platform.assets.domain.model.aggregates.Sensor;
import org.aquasense.platform.assets.domain.model.commands.CreateSensorCommand;
import org.aquasense.platform.assets.domain.services.SensorCommandService;
import org.aquasense.platform.assets.domain.services.SensorQueryService;
import org.aquasense.platform.assets.infrastructure.persistence.jpa.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SensorCommandServiceImpl  implements SensorCommandService {
    
   private final SensorRepository sensorRepository;

    public SensorCommandServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public Optional<Sensor> handle(CreateSensorCommand command) {
        var sensor = new Sensor(command);
        try {
            sensorRepository.save(sensor);
            return Optional.of(sensor);
        } catch (Exception e) {
            throw new IllegalArgumentException("Sensor already exists");
        }
    }
}
