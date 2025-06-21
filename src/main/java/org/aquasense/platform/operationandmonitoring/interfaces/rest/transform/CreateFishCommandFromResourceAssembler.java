package org.aquasense.platform.operationandmonitoring.interfaces.rest.transform;

import org.aquasense.platform.operationandmonitoring.domain.model.commands.CreateFishCommand;
import org.aquasense.platform.operationandmonitoring.interfaces.rest.resources.CreateFishResource;

public class CreateFishCommandFromResourceAssembler {
    public static CreateFishCommand toCommandFromResource(CreateFishResource resource) {
        return new CreateFishCommand(
                resource.type(),
                resource.weight(),
                resource.length(),
                resource.age()
        );
    }
}
