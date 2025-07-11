package org.aquasense.platform.om.domain.services;

import org.aquasense.platform.om.domain.model.aggregates.Notification;
import org.aquasense.platform.om.domain.model.queries.GetAllNotificationsQuery;


import java.util.List;

public interface NotificationQueryService {

    List<Notification> handle(GetAllNotificationsQuery query);

}
