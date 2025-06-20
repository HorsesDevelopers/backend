package org.aquasense.platform.operationandmonitoring.domain.model.aggregates;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.aquasense.platform.operationandmonitoring.domain.model.commands.CreatePondCommand;
import org.aquasense.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Entity
@Getter
@Setter
public class Pond extends AuditableAbstractAggregateRoot<Pond> {

    String ubication;

    String name;

    // TODO
    // scheduled feeding id
    // user id

    public Pond() {}

    public Pond(CreatePondCommand command) {
        this.ubication = command.ubication();
        this.name = command.name();
    }

}
