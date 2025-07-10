package org.aquasense.platform.om.interfaces.rest.resources;

import org.aquasense.platform.om.domain.model.valueobjects.RecordValue;

import java.util.List;

public record PondRecordResource(
        Long id,
        Long sensorId,
        Long pondId,
        List<RecordValue> values
) {
}
