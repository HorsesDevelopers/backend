package org.aquasense.platform.operationandmonitoring.application.internal.queryservices;

import org.aquasense.platform.operationandmonitoring.domain.model.aggregates.Pond;
import org.aquasense.platform.operationandmonitoring.domain.model.queries.GetAllPondsQuery;
import org.aquasense.platform.operationandmonitoring.domain.services.PondQueryService;
import org.aquasense.platform.operationandmonitoring.infrastructure.persistence.jpa.repositories.PondRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PondRQueryServiceImpl implements PondQueryService {

    private final PondRepository pondRepository;


    public PondRQueryServiceImpl(PondRepository pondRepository) {
        this.pondRepository = pondRepository;
    }

    @Override
    public List<Pond> handle(GetAllPondsQuery query) {
        return pondRepository.findAll();
    }
}
