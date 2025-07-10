package org.aquasense.platform.om.domain.model.commands;

import java.util.Date;

public record ReceivePondRecordCommand(
        Long pondId,
        float value,
        String recordType,
        Date timestamp
) {
}
