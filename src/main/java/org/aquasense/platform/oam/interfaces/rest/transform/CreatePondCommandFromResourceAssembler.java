package org.aquasense.platform.oam.interfaces.rest.transform;

import org.aquasense.platform.oam.domain.model.commands.CreatePondCommand;
import org.aquasense.platform.oam.interfaces.rest.resources.CreatePondResource;

public class CreatePondCommandFromResourceAssembler {
    public static CreatePondCommand toCommandFromResource(CreatePondResource resource) {
        return new CreatePondCommand(
                resource.ubication(),
                resource.name(),
                resource.waterType(),
                resource.volume(),
                resource.area()
        );
    }
}
