package org.aquasense.platform.assets.infrastructure.persistence.jpa.repository;

import org.aquasense.platform.assets.domain.model.aggregates.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor,Long> {
    // Find all dates for a specific sensor (for dashboard)
    List<LocalDateTime> findAllByTimeStampBetween(LocalDateTime start, LocalDateTime end);
}
