package org.aquasense.platform.om.domain.services;

import org.aquasense.platform.om.domain.model.entities.Fish;
import org.aquasense.platform.om.domain.model.queries.GetAllFishQuery;

import java.util.List;

public interface FishQueryService {

    List<Fish> handle(GetAllFishQuery query);
}
