package org.aquasense.platform.om.domain.services;

import org.aquasense.platform.om.domain.model.aggregates.Pond;
import org.aquasense.platform.om.domain.model.queries.GetAllPondsQuery;
import org.aquasense.platform.om.domain.model.queries.GetPondByIdQuery;

import java.util.List;
import java.util.Optional;

public interface PondQueryService {

    List<Pond> handle(GetAllPondsQuery query);

    Optional<Pond> handle(GetPondByIdQuery query);
}
