package org.aquasense.platform.oam.interfaces.rest.transform;

import org.aquasense.platform.oam.domain.model.commands.CreateFishCommand;
import org.aquasense.platform.oam.interfaces.rest.resources.CreateFishResource;

public class CreateFishCommandFromResourceAssembler {
    public static CreateFishCommand toCommandFromResource(CreateFishResource resource) {
        return new CreateFishCommand(
                resource.type(),
                resource.quantity(),
                resource.pondId()
        );
    }
}
