package org.aquasense.platform.om.domain.services;

import org.aquasense.platform.om.domain.model.aggregates.Notification;
import org.aquasense.platform.om.domain.model.commands.CreateNotificationCommand;

import java.util.Optional;

public interface NotificationCommandService {

    Optional<Notification> handle(CreateNotificationCommand command);
}
