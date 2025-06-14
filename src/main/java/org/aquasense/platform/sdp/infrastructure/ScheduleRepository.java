package org.aquasense.platform.sdp.infrastructure;

import org.aquasense.platform.sdp.domain.model.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
  boolean existsById(Long id);
}
