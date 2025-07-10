package org.aquasense.platform.om.application.internal.queryservices;

import org.aquasense.platform.om.domain.model.aggregates.Notification;
import org.aquasense.platform.om.domain.model.queries.GetAllNotificationsQuery;
import org.aquasense.platform.om.domain.services.NotificationQueryService;
import org.aquasense.platform.om.infrastructure.persistence.jpa.repositories.NotificationRepository;
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
