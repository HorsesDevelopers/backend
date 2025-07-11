package org.aquasense.platform.om.interfaces.rest.transform;

import org.aquasense.platform.om.domain.model.aggregates.Notification;
import org.aquasense.platform.om.interfaces.rest.resources.NotificationResource;

public class NotificationResourceFromEntityAssembler {
    public static NotificationResource toResourceFromEntity(Notification notification) {
        return new NotificationResource(
                notification.getId(),
                notification.getTitle(),
                notification.getDescription()
                );
    }
}
