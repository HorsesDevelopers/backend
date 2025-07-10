package org.aquasense.platform.om.domain.services;

import org.aquasense.platform.om.domain.model.entities.Fish;
import org.aquasense.platform.om.domain.model.commands.CreateFishCommand;

import java.util.Optional;

public interface FishCommandService {

    Optional<Fish> handle(CreateFishCommand command);
}
