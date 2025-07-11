package org.aquasense.platform.om.domain.model.commands;

public record UpdatePondCommand(Long id, String ubication, String name, String waterType, Double volume, Double area) {
}
