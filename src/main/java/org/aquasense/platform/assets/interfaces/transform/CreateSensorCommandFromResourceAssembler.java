package org.aquasense.platform.assets.interfaces.transform;

import org.aquasense.platform.assets.domain.model.commands.CreateSensorCommand;
import org.aquasense.platform.assets.interfaces.resources.CreateSensorResource;

public class CreateSensorCommandFromResourceAssembler {
    public static CreateSensorCommand toCommandFromResource(CreateSensorResource resource){
        return new CreateSensorCommand(resource.oxygenLevel(),
                resource.sensorType(),
                resource.status(),
                resource.temperatureLevel() != null ? resource.temperatureLevel() : 0.0f
                );
    }
}
