package org.aquasense.platform.om.interfaces.websocket;

import lombok.Data;

@Data
public class SensorData {
    private long sensorId;
    private double value;
}