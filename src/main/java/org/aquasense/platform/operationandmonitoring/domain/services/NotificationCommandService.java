package org.aquasense.platform.operationandmonitoring.domain.services;

import org.aquasense.platform.operationandmonitoring.domain.model.aggregates.Notification;
import org.aquasense.platform.operationandmonitoring.domain.model.commands.CreateNotificationCommand;

import java.util.Optional;

public interface NotificationCommandService {

    Optional<Notification> handle(CreateNotificationCommand command);
}
