package org.aquasense.platform.sdp.application.internal.commandservices;

import org.aquasense.platform.sdp.domain.model.commands.CreateScheduleCommand;
import org.aquasense.platform.sdp.domain.model.commands.UpdateScheduleCommand;
import org.aquasense.platform.sdp.domain.model.aggregates.Schedule;
import org.aquasense.platform.sdp.domain.services.ScheduleCommandService;
import org.aquasense.platform.sdp.infrastructure.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScheduleCommandServiceImpl implements ScheduleCommandService {
  private final ScheduleRepository scheduleRepository;

  public ScheduleCommandServiceImpl(ScheduleRepository scheduleRepository){
    this.scheduleRepository = scheduleRepository;
  }

  @Override
  public Long handle(CreateScheduleCommand command){
    Schedule schedule = new Schedule(
            command.name(),
            command.species(),
            command.size(),
            command.mass(),
            command.foodKind(),
            command.foodWeight(),
            command.loopC(),
            command.sensorConditionA(),
            command.sensorConditionB(),
            command.comment()
    );
    scheduleRepository.save(schedule);
    return schedule.getId();
  }

  @Override
  public Optional<Schedule> handle(UpdateScheduleCommand command) {
    var result = scheduleRepository.findById(command.scheduleId());
    if (result.isEmpty())
      throw new IllegalArgumentException("Schedule does not exist");
    var scheduleToUpdated = result.get();
    try{
      var updatedSchedule = scheduleRepository.save(scheduleToUpdated.updatedInformation(command.name(), command.species(), command.size(), command.mass(), command.foodKind(), command.foodWeight(), command.loopC(), command.sensorConditionA(), command.sensorConditionB(), command.comment()));
      return Optional.of(updatedSchedule);
    } catch (Exception e){
      throw new IllegalArgumentException("Error while updating schedule: " + e.getMessage());
    }
  }

}
