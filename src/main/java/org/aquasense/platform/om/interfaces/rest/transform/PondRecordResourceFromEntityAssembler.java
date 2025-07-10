package org.aquasense.platform.om.interfaces.rest.transform;

import org.aquasense.platform.om.domain.model.aggregates.Pond;
import org.aquasense.platform.om.domain.model.entities.PondRecord;
import org.aquasense.platform.om.interfaces.rest.resources.PondRecordResource;

public class PondRecordResourceFromEntityAssembler {
    public static PondRecordResource toResourceFromEntity(
            PondRecord entity
    ){
        return new PondRecordResource(
                entity.getId(),
                entity.getSensorId(),
                entity.getPond().getId(),
                entity.getValues()
        );
    }
}
