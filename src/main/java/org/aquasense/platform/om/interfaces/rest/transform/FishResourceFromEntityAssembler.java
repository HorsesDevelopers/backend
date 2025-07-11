package org.aquasense.platform.om.interfaces.rest.transform;

import org.aquasense.platform.om.domain.model.entities.Fish;
import org.aquasense.platform.om.interfaces.rest.resources.FishResource;

public class FishResourceFromEntityAssembler {
    public static FishResource toResourceFromEntity(Fish fish) {
        return new FishResource(
                fish.getId(),
                fish.getType(),
                fish.getQuantity(),
                fish.getPond() != null ? fish.getPond().getId() : null,
                fish.getCreatedAt().toString()
        );
    }
}
