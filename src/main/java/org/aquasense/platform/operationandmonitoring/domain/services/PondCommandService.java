package org.aquasense.platform.operationandmonitoring.domain.services;

import org.aquasense.platform.operationandmonitoring.domain.model.aggregates.Pond;
import org.aquasense.platform.operationandmonitoring.domain.model.commands.CreatePondCommand;

import java.util.Optional;

public interface PondCommandService {

    Optional<Pond> handle(CreatePondCommand command);
}
