package org.aquasense.platform.sdp.application.internal.queryservices;

import org.aquasense.platform.sdp.domain.model.aggregates.Schedule;
import org.aquasense.platform.sdp.domain.model.queries.GetAllSchedulesQuery;
import org.aquasense.platform.sdp.domain.model.queries.GetScheduleByIdQuery;
import org.aquasense.platform.sdp.domain.services.ScheduleQueryService;
import org.aquasense.platform.sdp.infrastructure.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleQueryServiceImpl implements ScheduleQueryService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleQueryServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<Schedule> handle(GetAllSchedulesQuery query){
        return scheduleRepository.findAll();
    }

    @Override
    public Optional<Schedule> handle(GetScheduleByIdQuery query){
        return scheduleRepository.findById(query.scheduleId());
    }

}
