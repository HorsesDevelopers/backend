package org.aquasense.platform.operationandmonitoring.domain.services;

import org.aquasense.platform.operationandmonitoring.domain.model.aggregates.Fish;
import org.aquasense.platform.operationandmonitoring.domain.model.commands.CreateFishCommand;

import java.util.Optional;

public interface FishCommandService {

    Optional<Fish> handle(CreateFishCommand command);
}
