package org.aquasense.platform.oam.application.internal.commandservices;

import org.aquasense.platform.oam.domain.model.aggregates.Fish;
import org.aquasense.platform.oam.domain.model.commands.CreateFishCommand;
import org.aquasense.platform.oam.domain.services.FishCommandService;
import org.aquasense.platform.oam.infrastructure.persistence.jpa.repositories.FishRepository;
import org.aquasense.platform.oam.infrastructure.persistence.jpa.repositories.PondRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FishCommandServiceImpl implements FishCommandService {

    private final FishRepository fishRepository;
    private final PondRepository pondRepository;

    public FishCommandServiceImpl(FishRepository fishRepository, PondRepository pondRepository) {
        this.fishRepository = fishRepository;
        this.pondRepository = pondRepository;
    }


    @Override
    public Optional<Fish> handle(CreateFishCommand command) {

        var pondOptional = pondRepository.findById(command.pondId());
        if (pondOptional.isEmpty()) {
            return Optional.empty();
        }
        var pond = pondOptional.get();

        var fish = new Fish(command, pond);


        fishRepository.save(fish);


        return Optional.of(fish);
    }
}
