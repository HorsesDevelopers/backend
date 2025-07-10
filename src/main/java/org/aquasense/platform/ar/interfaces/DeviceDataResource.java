package org.aquasense.platform.ar.interfaces;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceDataResource {

    private String device_Id;

    private String sensor_type;

    private String value;

    private String timestamp;

    private String status;



}
