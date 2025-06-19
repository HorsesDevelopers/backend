package org.aquasense.platform.operationandmonitoring.domain.model.aggregates;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.aquasense.platform.operationandmonitoring.domain.model.commands.CreateFishCommand;
import org.aquasense.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Entity
@Getter
@Setter
public class Fish extends AuditableAbstractAggregateRoot<Fish> {

    String type;

    Integer weight;

    Integer length;

    Integer age;


    public Fish() {}

    public Fish(CreateFishCommand command) {
        this.type = command.type();
        this.weight = command.weight();
        this.length = command.length();
        this.age = command.age();
    }


}
