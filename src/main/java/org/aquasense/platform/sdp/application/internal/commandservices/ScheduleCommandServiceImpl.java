package org.aquasense.platform.sdp.application.internal.commandservices;

import org.aquasense.platform.sdp.domain.model.commands.CreateScheduleCommand;
import org.aquasense.platform.sdp.domain.model.commands.DeleteScheduleCommand;
import org.aquasense.platform.sdp.domain.model.aggregates.Schedule;
import org.aquasense.platform.sdp.domain.services.ScheduleCommandService;
import org.aquasense.platform.sdp.infrastructure.persistence.jpa.repositories.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduleCommandServiceImpl implements ScheduleCommandService {
  private final ScheduleRepository scheduleRepository;

  public ScheduleCommandServiceImpl(ScheduleRepository scheduleRepository){
    this.scheduleRepository = scheduleRepository;
  }

  @Override
  public Long handle(CreateScheduleCommand command) {
    var schedule = new Schedule(command);
    scheduleRepository.save(schedule);
    return schedule.getId();
  }

  @Override
  public void handle(DeleteScheduleCommand command) {
    var schedule = scheduleRepository.findById(command.scheduleId());
    if (schedule.isPresent()) {
      scheduleRepository.delete(schedule.get());
    } else {
      throw new IllegalArgumentException("Schedule not found with id: " + command.scheduleId());
    }
  }
}
