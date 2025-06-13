package org.aquasense.platform.assets.interfaces.transform;

import org.aquasense.platform.assets.domain.model.commands.CreateSensorCommand;
import org.aquasense.platform.assets.interfaces.resources.CreateSensorResource;

public class CreateSensorCommandFromResourceAssembler {
    public static CreateSensorCommand toCommandFromResource(CreateSensorResource resource){
        return new CreateSensorCommand(resource.oxygenLevel(),
                resource.pHLevel(), resource.temperatureLevel());
    }
}
