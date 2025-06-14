package org.aquasense.platform.sdp.domain.model.commands;

public record UpdateScheduleCommand(long scheduleId, String name, String species, int size, int mass, String foodKind, int foodWeight, int loop, String sensorConditionA, String sensorConditionB, String comment) {
}
