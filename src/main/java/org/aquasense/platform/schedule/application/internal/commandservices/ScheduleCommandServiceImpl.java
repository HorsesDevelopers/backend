package org.aquasense.platform.schedule.application.internal.commandservices;

import org.aquasense.platform.schedule.domain.services.ScheduleCommandService;
import org.aquasense.platform.schedule.infrastructure.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduleCommandServiceImpl implements ScheduleCommandService {
  private final ScheduleRepository scheduleRepository;

  public ScheduleCommandServiceImpl(ScheduleRepository scheduleRepository){
    this.scheduleRepository = scheduleRepository;
  }

}
