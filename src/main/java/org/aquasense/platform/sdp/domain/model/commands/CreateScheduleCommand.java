package org.aquasense.platform.sdp.domain.model.commands;

public record CreateScheduleCommand(String name, String species, int size, int mass, String foodKind, int foodWeight, int loopC, String sensorConditionA, String sensorConditionB, String comment) {
}
