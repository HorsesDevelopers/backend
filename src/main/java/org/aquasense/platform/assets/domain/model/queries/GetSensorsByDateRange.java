package org.aquasense.platform.assets.domain.model.queries;

import java.time.LocalDateTime;

public record GetSensorsByDateRange(LocalDateTime start, LocalDateTime end) {
}
