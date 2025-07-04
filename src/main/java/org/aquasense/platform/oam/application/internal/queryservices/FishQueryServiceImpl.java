package org.aquasense.platform.oam.application.internal.queryservices;

import org.aquasense.platform.oam.domain.model.aggregates.Fish;
import org.aquasense.platform.oam.domain.model.queries.GetAllFishQuery;
import org.aquasense.platform.oam.domain.services.FishQueryService;
import org.aquasense.platform.oam.infrastructure.persistence.jpa.repositories.FishRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FishQueryServiceImpl implements FishQueryService {

    private final FishRepository fishRepository;


    public FishQueryServiceImpl(FishRepository fishRepository) {
        this.fishRepository = fishRepository;
    }

    @Override
    public List<Fish> handle(GetAllFishQuery query) {
        return fishRepository.findAll();
    }
}
