package org.aquasense.platform.operationandmonitoring.domain.model.commands;

public record CreateFishCommand(String type, Integer quantity, Long pondId) {
}
