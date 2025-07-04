package org.aquasense.platform.oam.domain.services;

import org.aquasense.platform.oam.domain.model.aggregates.Notification;
import org.aquasense.platform.oam.domain.model.queries.GetAllNotificationsQuery;


import java.util.List;

public interface NotificationQueryService {

    List<Notification> handle(GetAllNotificationsQuery query);

}
