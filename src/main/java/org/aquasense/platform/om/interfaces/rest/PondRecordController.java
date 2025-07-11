package org.aquasense.platform.om.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.aquasense.platform.om.application.internal.outboundservices.SensorDataProducer;
import org.aquasense.platform.om.domain.services.PondRecordCommandService;
import org.aquasense.platform.om.interfaces.rest.resources.PondRecordResource;
import org.aquasense.platform.om.interfaces.rest.resources.ReceivePondRecordCommandResource;
import org.aquasense.platform.om.interfaces.rest.transform.PondRecordResourceFromEntityAssembler;
import org.aquasense.platform.om.interfaces.rest.transform.ReceivePondRecordCommandFromResourceAssembler;
import org.aquasense.platform.om.interfaces.websocket.data.SensorData;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/pond_records", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Ponds Record", description = "Available Pond Record Endpoints")
public class PondRecordController {

    private final PondRecordCommandService pondRecordCommandService;
    private final SensorDataProducer sensorDataProducer;

    public PondRecordController(PondRecordCommandService pondRecordCommandService, SensorDataProducer sensorDataProducer) {
        this.pondRecordCommandService = pondRecordCommandService;
        this.sensorDataProducer = sensorDataProducer;
    }


    @PostMapping
    @Operation(summary = "Create PondRecord")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pond Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
    })
    public ResponseEntity<PondRecordResource> receivePondRecord(@RequestBody ReceivePondRecordCommandResource receivePondRecordCommandResource) {
        var command = ReceivePondRecordCommandFromResourceAssembler.toCommandFromResource(receivePondRecordCommandResource);
        var pondRecord = pondRecordCommandService.handle(command);
        if (pondRecord.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var pondRecordResource = PondRecordResourceFromEntityAssembler.toResourceFromEntity(pondRecord.get());
        SensorData sensorData = new SensorData();
        sensorData.setPondId(command.pondId());
        sensorData.setSensorType(command.recordType());
        sensorData.setValue(command.value());

        sensorDataProducer.publishSensorData(sensorData);

        return ResponseEntity.status(201).body(pondRecordResource);
    }
}
