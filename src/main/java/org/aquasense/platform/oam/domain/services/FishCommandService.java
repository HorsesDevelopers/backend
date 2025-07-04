package org.aquasense.platform.oam.domain.services;

import org.aquasense.platform.oam.domain.model.aggregates.Fish;
import org.aquasense.platform.oam.domain.model.commands.CreateFishCommand;

import java.util.Optional;

public interface FishCommandService {

    Optional<Fish> handle(CreateFishCommand command);
}
