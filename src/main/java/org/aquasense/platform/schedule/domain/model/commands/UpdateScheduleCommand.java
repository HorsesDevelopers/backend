package org.aquasense.platform.schedule.domain.model.commands;

public record UpdateScheduleCommand(long scheduleId, String name, String species, int size, int mass, String foodKind, int foodWeight, int loop, String sensorCondition, String comment) {
}
