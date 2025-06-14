package org.aquasense.platform.sdp.interfaces.rest.transform;

import org.aquasense.platform.sdp.domain.model.entities.Schedule;
import org.aquasense.platform.sdp.interfaces.rest.resources.ScheduleResource;

public class ScheduleResourceFromEntityAssembler {
    public static ScheduleResource toResourceFromEntity(Schedule entity){
        return new ScheduleResource(entity.getId(), entity.getName(), entity.getSpecies(), entity.getSize(),entity.getMass(),entity.getFoodKind(),entity.getFoodWeight(),entity.getLoop(), entity.getSensorConditionA(), entity.getSensorConditionB(), entity.getComment());
    }
}
