package org.aquasense.platform.om.domain.model.commands;

public record CreatePondCommand(String ubication, String name, String waterType, Double volume, Double area) {
}
