package org.aquasense.platform.ar.interfaces;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.aquasense.platform.ar.domain.model.queries.GetAllSensorsQuery;
import org.aquasense.platform.ar.domain.services.SensorCommandService;
import org.aquasense.platform.ar.domain.services.SensorQueryService;
import org.aquasense.platform.ar.interfaces.resources.SensorResource;
import org.aquasense.platform.ar.interfaces.transform.SensorResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/sensors")
@Tag(name = "Sensors", description = "Operations related to sensors")
public class SensorsController {

    private final SensorCommandService sensorCommandService;
    private final SensorQueryService sensorQueryService;

    public SensorsController(SensorCommandService sensorCommandService, SensorQueryService sensorQueryService) {
        this.sensorCommandService = sensorCommandService;
        this.sensorQueryService = sensorQueryService;
    }

    @GetMapping
    public ResponseEntity<List<SensorResource>> getAllSensors() {
        var sensors = sensorQueryService.handle(new GetAllSensorsQuery());
        var sensorResources = sensors.stream().map(SensorResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(sensorResources);
    }
}
