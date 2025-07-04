package org.aquasense.platform.oam.domain.services;

import org.aquasense.platform.oam.domain.model.aggregates.Pond;
import org.aquasense.platform.oam.domain.model.commands.CreatePondCommand;

import java.util.Optional;

public interface PondCommandService {

    Optional<Pond> handle(CreatePondCommand command);
}
