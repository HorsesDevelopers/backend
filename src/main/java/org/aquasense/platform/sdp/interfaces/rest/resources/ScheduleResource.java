package org.aquasense.platform.sdp.interfaces.rest.resources;

import org.aquasense.platform.sdp.domain.model.valueobjects.OpenDuration;

import java.time.LocalDate;
import java.time.LocalTime;

public record ScheduleResource(
    Long id,
    String name,
    Long pondId,
    LocalDate day,
    LocalTime hour,
    OpenDuration duration
) {
}
