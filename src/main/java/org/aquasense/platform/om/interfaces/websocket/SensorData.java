package org.aquasense.platform.om.interfaces.websocket;

import lombok.Data;

@Data
public class SensorData {
    private Long pondId;
    private String sensorType;
    private float value;
}