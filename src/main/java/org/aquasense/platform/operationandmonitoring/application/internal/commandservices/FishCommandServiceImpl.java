package org.aquasense.platform.operationandmonitoring.application.internal.commandservices;

import org.aquasense.platform.operationandmonitoring.domain.model.aggregates.Fish;
import org.aquasense.platform.operationandmonitoring.domain.model.commands.CreateFishCommand;
import org.aquasense.platform.operationandmonitoring.domain.services.FishCommandService;
import org.aquasense.platform.operationandmonitoring.infrastructure.persistence.jpa.repositories.FishRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FishCommandServiceImpl implements FishCommandService {

    private final FishRepository fishRepository;

    public FishCommandServiceImpl(FishRepository fishRepository) {
        this.fishRepository = fishRepository;
    }


    @Override
    public Optional<Fish> handle(CreateFishCommand command) {

        var fish = new Fish(command);

        fishRepository.save(fish);


        return Optional.of(fish);
    }
}
