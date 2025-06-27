package org.aquasense.platform.operationandmonitoring.infrastructure.persistence.jpa.repositories;

import org.aquasense.platform.operationandmonitoring.domain.model.aggregates.Fish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FishRepository extends JpaRepository<Fish, Long> {

    List<Fish> findByPondId(Long pondId);
    long countByPondId(Long pondId);
}
