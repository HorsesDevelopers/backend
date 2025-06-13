package org.aquasense.platform.schedule.domain.services;

import org.aquasense.platform.schedule.domain.model.commands.CreateScheduleCommand;
import org.aquasense.platform.schedule.domain.model.commands.UpdateScheduleCommand;
import org.aquasense.platform.schedule.domain.model.entities.Schedule;

import java.util.Optional;

public interface ScheduleCommandService {
  Long handle(CreateScheduleCommand command);
  Optional<Schedule> handle (UpdateScheduleCommand command);
}
