package org.aquasense.platform.om.domain.model.aggregates;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.aquasense.platform.om.domain.model.commands.CreatePondCommand;
import org.aquasense.platform.om.domain.model.entities.Fish;
import org.aquasense.platform.om.domain.model.entities.PondRecord;
import org.aquasense.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Pond extends AuditableAbstractAggregateRoot<Pond> {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<PondRecord> pondRecords = new ArrayList<>();

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

    public Pond() {
        this.ubication = "";
        this.name = "Pond without register";
        this.waterType = "";
        this.volume = 0.0;
        this.area = 0.0;
    }

    public Pond(CreatePondCommand command) {
        this.ubication = command.ubication();
        this.name = command.name();
        this.waterType = command.waterType();
        this.volume = command.volume();
        this.area = command.area();
    }

    public void addPondRecord(PondRecord pondRecord) {
        pondRecords.add(pondRecord);
        pondRecord.setPond(this);
    }
}
