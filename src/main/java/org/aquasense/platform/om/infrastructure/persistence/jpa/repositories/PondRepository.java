package org.aquasense.platform.om.infrastructure.persistence.jpa.repositories;

import org.aquasense.platform.om.domain.model.aggregates.Pond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PondRepository extends JpaRepository<Pond, Long> {
}
