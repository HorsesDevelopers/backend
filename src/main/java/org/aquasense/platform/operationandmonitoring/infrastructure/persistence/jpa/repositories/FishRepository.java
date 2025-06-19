package org.aquasense.platform.operationandmonitoring.infrastructure.persistence.jpa.repositories;

import org.aquasense.platform.operationandmonitoring.domain.model.aggregates.Fish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishRepository extends JpaRepository<Fish, Long> {
}
