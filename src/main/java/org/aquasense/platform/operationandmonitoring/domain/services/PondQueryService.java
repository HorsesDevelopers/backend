package org.aquasense.platform.operationandmonitoring.domain.services;

import org.aquasense.platform.operationandmonitoring.domain.model.aggregates.Pond;
import org.aquasense.platform.operationandmonitoring.domain.model.queries.GetAllPondsQuery;

import java.util.List;

public interface PondQueryService {

    List<Pond> handle(GetAllPondsQuery query);
}
