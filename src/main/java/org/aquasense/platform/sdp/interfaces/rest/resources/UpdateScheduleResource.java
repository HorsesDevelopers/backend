package org.aquasense.platform.sdp.interfaces.rest.resources;

public record UpdateScheduleResource(String name, String species, int size, int mass, String foodKind, int foodWeight, int loopC, String sensorConditionA, String sensorConditionB, String comment) {
}
