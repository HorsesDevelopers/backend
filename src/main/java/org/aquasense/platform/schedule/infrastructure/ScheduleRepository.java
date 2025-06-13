package org.aquasense.platform.schedule.infrastructure;

import org.aquasense.platform.schedule.domain.model.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
  boolean existsById(Long id);
}
