package org.aquasense.platform.ar.domain.model.queries;

public record GetSensorIdByPondIdAndTypeQuery(
        long pondId,
        String sensorType
) {
}
