package org.aquasense.platform.oam.application.internal.queryservices;

import org.aquasense.platform.oam.domain.model.aggregates.Notification;
import org.aquasense.platform.oam.domain.model.queries.GetAllNotificationsQuery;
import org.aquasense.platform.oam.domain.services.NotificationQueryService;
import org.aquasense.platform.oam.infrastructure.persistence.jpa.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationQueryServiceImpl implements NotificationQueryService {

    private final NotificationRepository notificationRepository;

    public NotificationQueryServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public List<Notification> handle(GetAllNotificationsQuery query) {
        return notificationRepository.findAll();
    }
}
