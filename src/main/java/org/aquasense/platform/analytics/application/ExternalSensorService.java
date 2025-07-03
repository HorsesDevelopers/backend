package org.aquasense.platform.analytics.application;

import org.aquasense.platform.analytics.domain.model.SensorSnapshot;
import org.aquasense.platform.assets.interfaces.acl.SensorFacade;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class ExternalSensorService {
    private final SensorFacade sensorFacade;

    public ExternalSensorService(SensorFacade sensorFacade) {
        this.sensorFacade = sensorFacade;
    }
    public List<SensorSnapshot> fetchSensorSnapshotsByDateRange(SensorSnapshot sensorSnapshot) {
        var snapshots = sensorFacade.getSensorsByDateRange(sensorSnapshot.lastUpdate(), sensorSnapshot.lastUpdate());
        if (snapshots == null || snapshots.isEmpty()) {
            return Collections.emptyList(); // lista vacía como referencia
        }
        return snapshots;
    }

}
