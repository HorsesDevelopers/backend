package org.aquasense.platform.aar.interfaces.transform;

import org.aquasense.platform.aar.domain.model.aggregates.Sensor;
import org.aquasense.platform.aar.interfaces.resources.SensorResource;

public class SensorResourceFromEntityAssembler {
    public static SensorResource toResourceFromEntity(Sensor sensor){
        return new SensorResource(
        sensor.getId(),
        sensor.getOxygen_level(),
        sensor.getSensor_type(),
        sensor.getStatus(),
        sensor.getWater_temp_level(),
        sensor.getLast_update());
    }
}
