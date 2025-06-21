package org.aquasense.platform.sdp.interfaces.rest;

import lombok.Getter;
import lombok.Setter;

public class DeviceDataResource {

    @Getter
    @Setter
    private String deviceId;
    @Setter
    @Getter
    private String type;
    @Setter
    @Getter
    private Float value;



}
