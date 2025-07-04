package org.aquasense.platform.oam.domain.services;

import org.aquasense.platform.oam.domain.model.aggregates.Fish;
import org.aquasense.platform.oam.domain.model.queries.GetAllFishQuery;

import java.util.List;

public interface FishQueryService {

    List<Fish> handle(GetAllFishQuery query);
}
