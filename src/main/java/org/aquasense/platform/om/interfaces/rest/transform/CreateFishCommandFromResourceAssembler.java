package org.aquasense.platform.om.interfaces.rest.transform;

import org.aquasense.platform.om.domain.model.commands.CreateFishCommand;
import org.aquasense.platform.om.interfaces.rest.resources.CreateFishResource;

public class CreateFishCommandFromResourceAssembler {
    public static CreateFishCommand toCommandFromResource(CreateFishResource resource) {
        return new CreateFishCommand(
                resource.type(),
                resource.quantity(),
                resource.pondId()
        );
    }
}
