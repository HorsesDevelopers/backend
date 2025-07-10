package org.aquasense.platform.ar.infrastructure.persistence.jpa.repository;

import org.aquasense.platform.ar.domain.model.entities.Sensor;
import org.aquasense.platform.ar.domain.model.valueobjects.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor,Long> {

    boolean existsSensorByPondIdAndType(Long pondId, SensorType type);

    long getSensorByPondIdAndType(Long pondId, SensorType type);
}