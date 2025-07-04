package org.aquasense.platform.aar.interfaces;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceDataResource {

    private String device_Id;

    private String sensor_type;

    private Float value;

    private String timestamp;

    private String status;



}
