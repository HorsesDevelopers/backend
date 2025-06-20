package org.aquasense.platform.operationandmonitoring.domain.model.commands;

public record CreateFishCommand(String type, Integer weight, Integer length, Integer age) {
}
