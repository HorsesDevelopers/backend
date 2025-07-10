package org.aquasense.platform.aar.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.aquasense.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class Devices extends AuditableAbstractAggregateRoot<Devices> {

    @Column(nullable = false)
    private Long pondId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String status;

    private String description;

    private LocalDateTime last_update;

    @Column(nullable = false)
    private boolean isRegistered;
}