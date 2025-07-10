package org.aquasense.platform.om.interfaces.rest.transform;

import org.aquasense.platform.om.domain.model.commands.CreateNotificationCommand;
import org.aquasense.platform.om.interfaces.rest.resources.CreateNotificationResource;

public class CreateNotificationCommandFromResourceAssembler {
    public static CreateNotificationCommand toCommandFromResource(CreateNotificationResource resource) {
        return new CreateNotificationCommand(
                resource.title(),
                resource.description()
        );
    }
}
