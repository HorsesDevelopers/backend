package org.aquasense.platform.oam.domain.services;

import org.aquasense.platform.oam.domain.model.aggregates.Pond;
import org.aquasense.platform.oam.domain.model.queries.GetAllPondsQuery;
import org.aquasense.platform.oam.domain.model.queries.GetPondByIdQuery;

import java.util.List;
import java.util.Optional;

public interface PondQueryService {

    List<Pond> handle(GetAllPondsQuery query);

    Optional<Pond> handle(GetPondByIdQuery query);
}
