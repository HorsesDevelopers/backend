package org.aquasense.platform.operationandmonitoring.domain.services;

import org.aquasense.platform.operationandmonitoring.domain.model.aggregates.Notification;
import org.aquasense.platform.operationandmonitoring.domain.model.queries.GetAllNotificationsQuery;


import java.util.List;

public interface NotificationQueryService {

    List<Notification> handle(GetAllNotificationsQuery query);

}
