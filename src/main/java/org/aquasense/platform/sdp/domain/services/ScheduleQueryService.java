package org.aquasense.platform.sdp.domain.services;

import org.aquasense.platform.sdp.domain.model.entities.Schedule;
import org.aquasense.platform.sdp.domain.model.queries.GetAllSchedulesQuery;
import org.aquasense.platform.sdp.domain.model.queries.GetScheduleByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ScheduleQueryService {
  List<Schedule> handle(GetAllSchedulesQuery query);
  Optional<Schedule> handle(GetScheduleByIdQuery query);
}
