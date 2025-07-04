package org.aquasense.platform.oam.domain.services;

import org.aquasense.platform.oam.domain.model.aggregates.Notification;
import org.aquasense.platform.oam.domain.model.commands.CreateNotificationCommand;

import java.util.Optional;

public interface NotificationCommandService {

    Optional<Notification> handle(CreateNotificationCommand command);
}
