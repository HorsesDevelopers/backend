package org.aquasense.platform.ar.interfaces.dto;

import lombok.Getter;
import lombok.Setter;
import org.aquasense.platform.ar.domain.model.valueobjects.DeviceStatus;
import org.aquasense.platform.ar.domain.model.valueobjects.SensorType;

@Getter
@Setter
public class SensorDataRequest {
    private Long deviceId;
    private SensorType sensorType;
    private String value;
    private Long timestamp;
    private DeviceStatus status = DeviceStatus.MAINTENANCE; // Valor por defecto

    public void setStatus(DeviceStatus status) {
        this.status = (status != null) ? status : DeviceStatus.MAINTENANCE;
    }
}
