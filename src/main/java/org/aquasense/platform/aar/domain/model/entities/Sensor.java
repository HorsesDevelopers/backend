package org.aquasense.platform.aar.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.aquasense.platform.aar.domain.model.aggregates.Devices;
import org.aquasense.platform.aar.domain.model.valueobjects.SensorType;
import org.aquasense.platform.aar.domain.model.valueobjects.SensorValue;

@Getter
@Setter
@Entity
@Table(name = "sensors")
public class Sensor extends Devices {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SensorType sensorType;
}