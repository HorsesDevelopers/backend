package org.aquasense.platform.om.application.internal.queryservices;

import org.aquasense.platform.om.domain.model.entities.Fish;
import org.aquasense.platform.om.domain.model.queries.GetAllFishQuery;
import org.aquasense.platform.om.domain.services.FishQueryService;
import org.aquasense.platform.om.infrastructure.persistence.jpa.repositories.FishRepository;
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
