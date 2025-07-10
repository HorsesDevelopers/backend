package org.aquasense.platform.om.domain.services;

import org.aquasense.platform.om.domain.model.entities.PondRecord;
import org.aquasense.platform.om.domain.model.queries.GetPondRecordBySensorIdQuery;

import java.util.Optional;

public interface PondRecordQueryService {
    Optional<PondRecord> handle(GetPondRecordBySensorIdQuery query);
}
