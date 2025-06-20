package org.aquasense.platform.operationandmonitoring.interfaces.rest.transform;

import org.aquasense.platform.operationandmonitoring.domain.model.commands.CreateNotificationCommand;
import org.aquasense.platform.operationandmonitoring.interfaces.rest.resources.CreateNotificationResource;

public class CreateNotificationCommandFromResourceAssembler {
    public static CreateNotificationCommand toCommandFromResource(CreateNotificationResource resource) {
        return new CreateNotificationCommand(
                resource.title(),
                resource.description()
        );
    }
}
