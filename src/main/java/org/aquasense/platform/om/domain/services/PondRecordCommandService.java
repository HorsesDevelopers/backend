package org.aquasense.platform.om.domain.services;

import org.aquasense.platform.om.domain.model.commands.ReceivePondRecordCommand;
import org.aquasense.platform.om.domain.model.entities.PondRecord;

import java.util.Optional;

public interface PondRecordCommandService {
    Optional<PondRecord> handle(ReceivePondRecordCommand command);
}
