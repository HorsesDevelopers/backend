package org.aquasense.platform.operationandmonitoring.interfaces.rest.transform;

import org.aquasense.platform.operationandmonitoring.domain.model.aggregates.Fish;
import org.aquasense.platform.operationandmonitoring.interfaces.rest.resources.FishResource;

public class FishResourceFromEntityAssembler {
    public static FishResource toResourceFromEntity(Fish fish) {
        return new FishResource(
                fish.getId(),
                fish.getType(),
                fish.getWeight(),
                fish.getLength(),
                fish.getAge()
        );
    }
}
