package org.aquasense.platform.operationandmonitoring.interfaces.rest.resources;

public record CreateFishResource(String type, Integer weight, Integer length, Integer age) {
    public CreateFishResource {
        if (type == null || type.isEmpty()) throw new IllegalArgumentException("type is required");
        if (weight == null || weight == 0) throw new IllegalArgumentException("weight is required");
        if (length == null || length == 0) throw new IllegalArgumentException("length is required");
        if (age == null || age == 0) throw new IllegalArgumentException("age is required");
    }
}
