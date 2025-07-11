package org.aquasense.platform.ar.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.aquasense.platform.ar.domain.model.aggregates.Device;

@Getter
@Setter
@Entity
@Table(name = "actuators")
public class Actuator extends Device {

    @Column(nullable = false)
    private float foodCapacity;

    @Column(nullable = false)
    private boolean isEmpty;
}