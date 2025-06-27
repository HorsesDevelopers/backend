package org.aquasense.platform.operationandmonitoring.domain.model.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.aquasense.platform.operationandmonitoring.domain.model.commands.CreateFishCommand;
import org.aquasense.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Entity
@Getter
@Setter
public class Fish extends AuditableAbstractAggregateRoot<Fish> {

    String type;

    Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pond_id")
    private Pond pond;

    Integer weight;

    Integer length;

    Integer age;


    public Fish() {}

    public Fish(CreateFishCommand command, Pond pond) {
        this.type = command.type();
        this.pond = pond;
        this.quantity = command.quantity();
        this.weight = 0; // Default value, can be updated later
        this.length = 0; // Default value, can be updated later
        this.age = 0; // Default value, can be updated later
    }


}
