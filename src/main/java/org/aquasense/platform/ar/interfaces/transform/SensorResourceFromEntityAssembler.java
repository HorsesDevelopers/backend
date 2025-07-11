package org.aquasense.platform.ar.interfaces.transform;

import org.aquasense.platform.ar.domain.model.entities.Sensor;
import org.aquasense.platform.ar.interfaces.resources.SensorResource;

public class SensorResourceFromEntityAssembler {
    public static SensorResource toResourceFromEntity(Sensor sensor){
        return new SensorResource(
                sensor.getId(),
                sensor.getType().toString(),
                sensor.getMaxValue(),
                sensor.getMinValue()
        );
    };
}
