package org.aquasense.platform.om.infrastructure.persistence.jpa.repositories;

import org.aquasense.platform.om.domain.model.entities.PondRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PondRecordRepository extends JpaRepository<PondRecord, Long> {
    Optional<PondRecord> getPondRecordBySensorId(Long sensorId);
}
