package org.aquasense.platform.om.interfaces.rest.resources;

import java.util.Date;

public record ReceivePondRecordCommandResource(
        Long pondId,
        float value,
        String recordType,
        Date timestamp
) {
}
