package org.aquasense.platform.sdp.infrastructure;

import org.aquasense.platform.sdp.domain.model.aggregates.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
  boolean existsById(Long id);
}
