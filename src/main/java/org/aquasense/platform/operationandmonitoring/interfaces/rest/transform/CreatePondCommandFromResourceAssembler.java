package org.aquasense.platform.operationandmonitoring.interfaces.rest.transform;

import org.aquasense.platform.operationandmonitoring.domain.model.commands.CreatePondCommand;
import org.aquasense.platform.operationandmonitoring.interfaces.rest.resources.CreatePondResource;

public class CreatePondCommandFromResourceAssembler {
    public static CreatePondCommand toCommandFromResource(CreatePondResource resource) {
        return new CreatePondCommand(
                resource.ubication(),
                resource.name()
        );
    }
}
