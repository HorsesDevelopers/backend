package org.aquasense.platform.om.domain.model.commands;

public record CreateFishCommand(String type, Integer quantity, Long pondId) {
}
