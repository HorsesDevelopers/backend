package org.aquasense.platform.om.application.internal.commandservices;

import org.aquasense.platform.om.domain.model.aggregates.Notification;
import org.aquasense.platform.om.domain.model.commands.CreateNotificationCommand;
import org.aquasense.platform.om.domain.services.NotificationCommandService;
import org.aquasense.platform.om.infrastructure.persistence.jpa.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationCommandServiceImpl implements NotificationCommandService {

    private final NotificationRepository notificationRepository;

    public NotificationCommandServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Optional<Notification> handle(CreateNotificationCommand command) {
        var notification = new Notification(command);
        notificationRepository.save(notification);
        return Optional.of(notification);
    }
}
