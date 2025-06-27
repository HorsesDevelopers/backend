package org.aquasense.platform.assets.domain.model.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.aquasense.platform.assets.domain.model.commands.CreateSensorCommand;
import org.aquasense.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@Table(name = "sensors")
public class Sensor  extends AuditableAbstractAggregateRoot<Sensor> {

    private int oxygen_level;

    //private int pH_level;

    private String sensor_type;

    private Float water_temp_level;

    private String status;

    private LocalDateTime last_update;

    public Sensor() {}


    public Sensor(CreateSensorCommand command) {
        this.oxygen_level = (command.oxygen_level() == 0) ? 1 : command.oxygen_level();
        //this.pH_level = command.pH_level();
        this.status = command.status();
        this.water_temp_level = command.water_temp_level();
        this.last_update = LocalDateTime.now();
    }
}
