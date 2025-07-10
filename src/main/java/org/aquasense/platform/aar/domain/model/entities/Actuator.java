package org.aquasense.platform.aar.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.aquasense.platform.aar.domain.model.aggregates.Devices;

@Getter
@Setter
@Entity
@Table(name = "actuators")
public class Actuator extends Devices {

    @Column(nullable = false)
    private float foodCapacity;

    @Column(nullable = false)
    private boolean isEmpty;
}