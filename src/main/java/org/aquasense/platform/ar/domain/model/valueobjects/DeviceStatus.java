package org.aquasense.platform.ar.domain.model.valueobjects;

public enum DeviceStatus {
    ACTIVE,
    INACTIVE,
    MAINTENANCE,
    ERROR;

    public boolean isActive() {
        return this == ACTIVE;
    }

    public boolean isInactive() {
        return this == INACTIVE;
    }

    public boolean isUnderMaintenance() {
        return this == MAINTENANCE;
    }

    public boolean hasError() {
        return this == ERROR;
    }
}
