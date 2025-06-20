package org.aquasense.platform.assets.interfaces;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.aquasense.platform.assets.domain.model.queries.GetSensorByIdQuery;
import org.aquasense.platform.assets.domain.model.queries.GetSensorsByDateRange;
import org.aquasense.platform.assets.domain.services.SensorCommandService;
import org.aquasense.platform.assets.domain.services.SensorQueryService;
import org.aquasense.platform.assets.interfaces.resources.CreateSensorResource;
import org.aquasense.platform.assets.interfaces.resources.SensorResource;
import org.aquasense.platform.assets.interfaces.transform.CreateSensorCommandFromResourceAssembler;
import org.aquasense.platform.assets.interfaces.transform.SensorResourceFromEntityAssembler;
import org.springframework.cglib.core.Local;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping(value = "/api/v1/sensors", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Sensors", description = "Sensor Management Endpoints")
public class SensorController {

    private final SensorQueryService sensorQueryService;
    private final SensorCommandService sensorCommandService;

    public SensorController(SensorQueryService sensorQueryService, SensorCommandService sensorCommandService) {
        this.sensorQueryService = sensorQueryService;
        this.sensorCommandService = sensorCommandService;
    }

    @PostMapping
    @Operation(summary = "Create a new sensor")
    public ResponseEntity<SensorResource> createSensor(@RequestBody CreateSensorResource resource) {
        var createSensorCommand = CreateSensorCommandFromResourceAssembler.toCommandFromResource(resource);
        var sensorId = this.sensorCommandService.handle(createSensorCommand);
        if(sensorId.isEmpty()) {return ResponseEntity.notFound().build();}
        var getSensorByIdQuery = new GetSensorByIdQuery(sensorId.get().getId());
        var optionalSensor = this.sensorQueryService.handle(getSensorByIdQuery);
        if(optionalSensor.isEmpty()) {return ResponseEntity.notFound().build();}
        var sensorResource = SensorResourceFromEntityAssembler.toResourceFromEntity(optionalSensor.get());
        return ResponseEntity.ok(sensorResource);
    }

    @GetMapping("/by-date")
    public ResponseEntity<List<SensorResource>> getSensorsByDateRange(@RequestParam LocalDateTime start, LocalDateTime end){
        var getSensorsByDateRange = new GetSensorsByDateRange(start, end);
        var optionalSensorsRange = this.sensorQueryService.handle(getSensorsByDateRange);
        var sensorResources = optionalSensorsRange.stream()
                .map(SensorResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(sensorResources);
    }



}
