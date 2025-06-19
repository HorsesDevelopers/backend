package org.aquasense.platform.operationandmonitoring.domain.services;

import org.aquasense.platform.operationandmonitoring.domain.model.aggregates.Fish;
import org.aquasense.platform.operationandmonitoring.domain.model.queries.GetAllFishQuery;

import java.util.List;

public interface FishQueryService {

    List<Fish> handle(GetAllFishQuery query);
}
