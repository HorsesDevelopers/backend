package org.aquasense.platform.oam.domain.model.commands;

public record CreateFishCommand(String type, Integer quantity, Long pondId) {
}
