package org.aquasense.platform.oam.interfaces.rest.transform;

import org.aquasense.platform.oam.domain.model.aggregates.Pond;
import org.aquasense.platform.oam.interfaces.rest.resources.FishResource;
import org.aquasense.platform.oam.interfaces.rest.resources.PondResource;

import java.util.List;

public class PondResourceFromEntityAssembler {
    public static PondResource toResourceFromEntity(Pond pond) {

        List<FishResource> fishResources = pond.getFishes().stream()
                .map(FishResourceFromEntityAssembler::toResourceFromEntity)
                .toList();

        return new PondResource(
                pond.getId(),
                pond.getUbication(),
                pond.getName(),
                pond.getWaterType(),
                fishResources,
                pond.getVolume(),
                pond.getArea(),
                pond.getCreatedAt().toString()
        );
    }
}
