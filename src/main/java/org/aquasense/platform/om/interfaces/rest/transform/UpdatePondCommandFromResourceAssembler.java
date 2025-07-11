package org.aquasense.platform.om.interfaces.rest.transform;

import org.aquasense.platform.om.domain.model.commands.UpdatePondCommand;
import org.aquasense.platform.om.interfaces.rest.resources.UpdatePondResource;

public class UpdatePondCommandFromResourceAssembler {
    public static UpdatePondCommand toCommandFromResource(Long pondId, UpdatePondResource resource) {
        return new UpdatePondCommand(
                pondId,
                resource.ubication(),
                resource.name(),
                resource.waterType(),
                resource.volume(),
                resource.area()
        );
    }
}
