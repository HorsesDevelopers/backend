package org.aquasense.platform.ar.domain.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.aquasense.platform.ar.domain.model.aggregates.Device;
import org.aquasense.platform.ar.domain.model.commands.CreateSensorCommand;
import org.aquasense.platform.ar.domain.model.valueobjects.SensorType;


@Entity
@Getter
@Setter
@Table(name = "sensors")
public class Sensor  extends Device {

    private SensorType type;

    private float maxValue;

    private float minValue;

    public Sensor() {
        super();
    }


    public Sensor(CreateSensorCommand command) {
        super(command.pondId());
        this.type = SensorType.valueOf(command.type());
        this.maxValue = command.maxValue();
        this.minValue = command.minValue();
    }
}
