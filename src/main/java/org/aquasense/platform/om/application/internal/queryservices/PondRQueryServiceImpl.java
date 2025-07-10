package org.aquasense.platform.om.application.internal.queryservices;

import org.aquasense.platform.om.domain.model.aggregates.Pond;
import org.aquasense.platform.om.domain.model.queries.GetAllPondsQuery;
import org.aquasense.platform.om.domain.model.queries.GetPondByIdQuery;
import org.aquasense.platform.om.domain.services.PondQueryService;
import org.aquasense.platform.om.infrastructure.persistence.jpa.repositories.PondRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Pond> handle(GetPondByIdQuery query) {
        return pondRepository.findById(query.id());
    }
}
