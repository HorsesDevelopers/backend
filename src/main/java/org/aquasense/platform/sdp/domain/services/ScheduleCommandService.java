package org.aquasense.platform.sdp.domain.services;

import org.aquasense.platform.sdp.domain.model.commands.CreateScheduleCommand;
import org.aquasense.platform.sdp.domain.model.commands.UpdateScheduleCommand;
import org.aquasense.platform.sdp.domain.model.aggregates.Schedule;

import java.util.Optional;

public interface ScheduleCommandService {
  Long handle(CreateScheduleCommand command);
  Optional<Schedule> handle (UpdateScheduleCommand command);
}
