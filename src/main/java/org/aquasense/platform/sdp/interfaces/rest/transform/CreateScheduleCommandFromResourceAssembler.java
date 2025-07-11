package org.aquasense.platform.sdp.interfaces.rest.transform;

import org.aquasense.platform.sdp.domain.model.commands.CreateScheduleCommand;
import org.aquasense.platform.sdp.interfaces.rest.resources.CreateScheduleResource;

public class CreateScheduleCommandFromResourceAssembler {
    public static CreateScheduleCommand toCommandFromResource(CreateScheduleResource resource){
        return new CreateScheduleCommand(
                resource.name(),
                resource.pondId(),
                resource.day(),
                resource.hour(),
                resource.duration()
        );
    }
}
