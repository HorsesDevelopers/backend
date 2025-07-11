package org.aquasense.platform.sdp.interfaces.rest.transform;

import org.aquasense.platform.sdp.domain.model.aggregates.Schedule;
import org.aquasense.platform.sdp.interfaces.rest.resources.ScheduleResource;

public class ScheduleResourceFromEntityAssembler {
    public static ScheduleResource toResourceFromEntity(Schedule entity){
        return new ScheduleResource(
                entity.getId(),
                entity.getName(),
                entity.getPondId(),
                entity.getDay(),
                entity.getHour(),
                entity.getDuration()
        );
    }
}
