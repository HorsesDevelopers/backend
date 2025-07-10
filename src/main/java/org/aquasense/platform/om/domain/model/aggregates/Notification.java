package org.aquasense.platform.om.domain.model.aggregates;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.aquasense.platform.om.domain.model.commands.CreateNotificationCommand;
import org.aquasense.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;


@Entity
@Getter
@Setter
public class Notification extends AuditableAbstractAggregateRoot<Notification> {

    String title;
    String description;

    // TODO
    // PondId

    public Notification() {
    }

    public Notification(CreateNotificationCommand command) {
        this.title = command.title();
        this.description = command.description();
    }
}
