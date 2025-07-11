package org.aquasense.platform.om.application.internal.outboundservices;

import org.aquasense.platform.ar.interfaces.acl.ARContextFacade;
import org.springframework.stereotype.Service;

@Service
public class ExternalAROMService {

    private final ARContextFacade arContextFacade;

    public ExternalAROMService(ARContextFacade arContextFacade) {
        this.arContextFacade = arContextFacade;
    }

    public long createSensor(
            Long pondId,
            String type,
            float maxValue,
            float minValue
    ){
        return arContextFacade.createSensor(pondId, type, maxValue, minValue);
    }

    public boolean existSensorByPondIdAndType(
            Long pondId,
            String type
    ){
        return arContextFacade.existSensorByPondIdAndType(pondId, type);
    }

    public long getSensorIdByPondIdAndType(
            Long pondId,
            String type
    ){
        return arContextFacade.getSensorIdByPondIdAndType(pondId, type);
    }
}
