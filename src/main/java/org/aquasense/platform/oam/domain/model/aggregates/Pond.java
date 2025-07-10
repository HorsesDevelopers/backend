package org.aquasense.platform.oam.domain.model.aggregates;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.aquasense.platform.oam.domain.model.commands.CreatePondCommand;
import org.aquasense.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Pond extends AuditableAbstractAggregateRoot<Pond> {

    String ubication;

    String name;

    String waterType;

    Double volume;

    Double area;

    @OneToMany(mappedBy = "pond", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Fish> fishes = new ArrayList<>();


    // TODO
    // scheduled feeding id
    // user id

    public Pond() {}

    public Pond(CreatePondCommand command) {
        this.ubication = command.ubication();
        this.name = command.name();
        this.waterType = command.waterType();
        this.volume = command.volume();
        this.area = command.area();
    }

}
