package org.aquasense.platform.operationandmonitoring.infrastructure.persistence.jpa.repositories;

import org.aquasense.platform.operationandmonitoring.domain.model.aggregates.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    //TODO implement notificaions validations
}
