package org.aquasense.platform.ar.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.aquasense.platform.ar.domain.model.valueobjects.DeviceStatus;
import org.aquasense.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class Device extends AuditableAbstractAggregateRoot<Device> {

    @Column(nullable = false)
    private Long pondId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private DeviceStatus status;

    private String description;

    private LocalDateTime lastUpdate;

    @Column(nullable = false)
    private boolean isRegistered;

    public Device() {}

    public Device(Long pondId) {
        this.pondId = pondId;
        this.name = "Not registered yet";
        this.status = DeviceStatus.ACTIVE;
        this.description = "No description provided";
        this.lastUpdate = LocalDateTime.now();
        this.isRegistered = false;
    }
}