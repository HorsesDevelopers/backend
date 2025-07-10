package org.aquasense.platform.oam.interfaces.rest.transform;

import org.aquasense.platform.oam.domain.model.aggregates.Fish;
import org.aquasense.platform.oam.interfaces.rest.resources.FishResource;

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
