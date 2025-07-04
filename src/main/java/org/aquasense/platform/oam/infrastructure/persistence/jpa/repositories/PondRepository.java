package org.aquasense.platform.oam.infrastructure.persistence.jpa.repositories;

import org.aquasense.platform.oam.domain.model.aggregates.Pond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PondRepository extends JpaRepository<Pond, Long> {
}
