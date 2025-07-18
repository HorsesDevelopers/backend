package org.aquasense.platform.om.domain.services;

import org.aquasense.platform.om.domain.model.aggregates.Pond;
import org.aquasense.platform.om.domain.model.commands.CreatePondCommand;
import org.aquasense.platform.om.domain.model.commands.UpdatePondCommand;

import java.util.Optional;

public interface PondCommandService {

    Optional<Pond> handle(CreatePondCommand command);
    Optional<Pond> handle(UpdatePondCommand command);
}
