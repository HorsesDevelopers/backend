package org.aquasense.platform.operationandmonitoring.interfaces.rest.transform;

import org.aquasense.platform.operationandmonitoring.domain.model.aggregates.Notification;
import org.aquasense.platform.operationandmonitoring.interfaces.rest.resources.NotificationResource;

public class NotificationResourceFromEntityAssembler {
    public static NotificationResource toResourceFromEntity(Notification notification) {
        return new NotificationResource(
                notification.getId(),
                notification.getTitle(),
                notification.getDescription()
                );
    }
}
