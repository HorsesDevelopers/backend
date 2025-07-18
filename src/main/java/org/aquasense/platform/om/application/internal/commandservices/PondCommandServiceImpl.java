package org.aquasense.platform.om.application.internal.commandservices;

import org.aquasense.platform.om.domain.model.aggregates.Pond;
import org.aquasense.platform.om.domain.model.commands.CreatePondCommand;
import org.aquasense.platform.om.domain.model.commands.UpdatePondCommand;
import org.aquasense.platform.om.domain.services.PondCommandService;
import org.aquasense.platform.om.infrastructure.persistence.jpa.repositories.PondRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PondCommandServiceImpl implements PondCommandService {

    private final PondRepository pondRepository;


    public PondCommandServiceImpl(PondRepository pondRepository) {
        this.pondRepository = pondRepository;
    }

    @Override
    public Optional<Pond> handle(CreatePondCommand command) {

        var pond = new Pond(command);

        pondRepository.save(pond);

        return  Optional.of(pond);
    }

    @Override
    public Optional<Pond> handle(UpdatePondCommand command) {
        var result = pondRepository.findById(command.id());
        var pondToUpdate=result.get();
        var updatedPond = pondRepository.save(pondToUpdate.updateInformation(command.ubication(),command.name(), command.waterType(), command.volume(), command.area()));
        return  Optional.of(updatedPond);
    }
}
