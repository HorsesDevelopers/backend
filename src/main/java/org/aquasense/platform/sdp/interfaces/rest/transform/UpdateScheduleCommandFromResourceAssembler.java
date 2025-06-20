package org.aquasense.platform.sdp.interfaces.rest.transform;

import org.aquasense.platform.sdp.domain.model.commands.UpdateScheduleCommand;
import org.aquasense.platform.sdp.interfaces.rest.resources.UpdateScheduleResource;

public class UpdateScheduleCommandFromResourceAssembler {
    public static UpdateScheduleCommand toCommandFromResource(Long id, UpdateScheduleResource resource){
        return new UpdateScheduleCommand(id,resource.name(),resource.species(),resource.size(),resource.mass(),resource.foodKind(),resource.foodWeight(),resource.loopC(),resource.sensorConditionA(),resource.sensorConditionB(),resource.comment());
    }
}
