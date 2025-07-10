package org.aquasense.platform.ar.interfaces.transform;

import org.aquasense.platform.ar.domain.model.commands.CreateSensorCommand;
import org.aquasense.platform.ar.interfaces.resources.CreateSensorResource;

public class CreateSensorCommandFromResourceAssembler {
    public static CreateSensorCommand toCommandFromResource(CreateSensorResource resource){
        return new CreateSensorCommand(
                resource.pondId(),
                resource.type(),
                resource.maxValue(),
                resource.minValue()
                );
    }
}
