package org.aquasense.platform.om.interfaces.rest.transform;

import org.aquasense.platform.om.domain.model.commands.ReceivePondRecordCommand;
import org.aquasense.platform.om.interfaces.rest.resources.ReceivePondRecordCommandResource;

public class ReceivePondRecordCommandFromResourceAssembler {
    public static ReceivePondRecordCommand toCommandFromResource(
            ReceivePondRecordCommandResource resource) {
        return new ReceivePondRecordCommand(
                resource.pondId(),
                resource.value(),
                resource.recordType(),
                resource.timestamp()
        );
    }
}
