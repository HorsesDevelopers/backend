package org.aquasense.platform.oam.interfaces.rest.transform;

import org.aquasense.platform.oam.domain.model.aggregates.Notification;
import org.aquasense.platform.oam.interfaces.rest.resources.NotificationResource;

public class NotificationResourceFromEntityAssembler {
    public static NotificationResource toResourceFromEntity(Notification notification) {
        return new NotificationResource(
                notification.getId(),
                notification.getTitle(),
                notification.getDescription()
                );
    }
}
