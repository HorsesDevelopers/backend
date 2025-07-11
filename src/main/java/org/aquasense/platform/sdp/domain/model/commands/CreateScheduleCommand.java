package org.aquasense.platform.sdp.domain.model.commands;

import org.aquasense.platform.sdp.domain.model.valueobjects.OpenDuration;

import java.time.LocalDate;
import java.time.LocalTime;

public record CreateScheduleCommand(
        String name,
        Long pondId,
        LocalDate day,
        LocalTime hour,
        OpenDuration duration
) {
}
