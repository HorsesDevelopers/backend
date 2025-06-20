package org.aquasense.platform.assets.domain.model.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aquasense.platform.assets.domain.model.commands.CreateSensorCommand;
import org.aquasense.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@Table(name = "sensors")
public class Sensor extends AuditableAbstractAggregateRoot<Sensor> {

    private int oxygen_level;

    private int pH_level;

    private int water_temp_level;

    private LocalDateTime lastUpdate;

    public Sensor() {}

    public Sensor(int oxygen_level, int pH_level, int water_temp_level) {
        this.oxygen_level = oxygen_level;
        this.pH_level = pH_level;
        this.water_temp_level = water_temp_level;
        this.lastUpdate = LocalDateTime.now();
    }

    public Sensor(CreateSensorCommand command) {
        this.oxygen_level = command.oxygen_level();
        this.pH_level = command.pH_level();
        this.water_temp_level = command.water_temp_level();
        this.lastUpdate = LocalDateTime.now();
    }
}
