package org.aquasense.platform.assets.interfaces.transform;

import org.aquasense.platform.assets.domain.model.aggregates.Sensor;
import org.aquasense.platform.assets.interfaces.resources.SensorResource;

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
