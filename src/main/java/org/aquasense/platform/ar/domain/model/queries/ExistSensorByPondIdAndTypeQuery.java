package org.aquasense.platform.ar.domain.model.queries;

public record ExistSensorByPondIdAndTypeQuery(
        long pondId,
        String sensorType
) {
}
