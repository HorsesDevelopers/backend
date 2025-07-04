package org.aquasense.platform.oam.interfaces.rest.transform;

import org.aquasense.platform.oam.domain.model.commands.CreateNotificationCommand;
import org.aquasense.platform.oam.interfaces.rest.resources.CreateNotificationResource;

public class CreateNotificationCommandFromResourceAssembler {
    public static CreateNotificationCommand toCommandFromResource(CreateNotificationResource resource) {
        return new CreateNotificationCommand(
                resource.title(),
                resource.description()
        );
    }
}
