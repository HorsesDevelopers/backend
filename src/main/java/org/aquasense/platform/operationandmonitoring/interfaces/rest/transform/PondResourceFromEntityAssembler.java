package org.aquasense.platform.operationandmonitoring.interfaces.rest.transform;

import org.aquasense.platform.operationandmonitoring.domain.model.aggregates.Pond;
import org.aquasense.platform.operationandmonitoring.interfaces.rest.resources.PondResource;

public class PondResourceFromEntityAssembler {
    public static PondResource toResourceFromEntity(Pond pond) {
        return new PondResource(
                pond.getId(),
                pond.getUbication(),
                pond.getName()

        );
    }
}
