package org.aquasense.platform.om.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.aquasense.platform.om.domain.model.queries.GetAllPondsQuery;
import org.aquasense.platform.om.domain.model.queries.GetPondByIdQuery;
import org.aquasense.platform.om.domain.services.PondCommandService;
import org.aquasense.platform.om.domain.services.PondQueryService;
import org.aquasense.platform.om.interfaces.rest.resources.CreatePondResource;
import org.aquasense.platform.om.interfaces.rest.resources.PondResource;
import org.aquasense.platform.om.interfaces.rest.transform.CreatePondCommandFromResourceAssembler;
import org.aquasense.platform.om.interfaces.rest.transform.PondResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/ponds", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Ponds", description = "Available Pond Endpoints")
public class PondsController {

    private final PondCommandService pondCommandService;
    private final PondQueryService pondQueryService;

    public PondsController(PondCommandService pondCommandService, PondQueryService pondQueryService) {
        this.pondCommandService = pondCommandService;
        this.pondQueryService = pondQueryService;
    }

    @GetMapping
    @Operation(summary = "Get All Ponds")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ponds Found"),
            @ApiResponse(responseCode = "400", description = "Ponds Not Found"),
    })
    public ResponseEntity<List<PondResource>> getAllPonds() {
        var ponds = pondQueryService.handle(new GetAllPondsQuery());
        if (ponds.isEmpty()) return ResponseEntity.notFound().build();
        var pondsResource = ponds.stream()
                .map(PondResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(pondsResource);
    }

    @GetMapping("/{pondId}")
    @Operation(summary = "Get Pond by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pond Found"),
            @ApiResponse(responseCode = "404", description = "Pond Not Found"),
    })
    public ResponseEntity<PondResource> getPondById(@PathVariable("pondId") Long pondId) {
        var pond = pondQueryService.handle(new GetPondByIdQuery(pondId));
        if (pond.isEmpty()) return ResponseEntity.notFound().build();
        var pondResource = PondResourceFromEntityAssembler.toResourceFromEntity(pond.get());
        return ResponseEntity.ok(pondResource);
    }

    @PostMapping
    @Operation(summary = "Create Pond")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pond Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
    })
    public ResponseEntity<PondResource> createPond(@RequestBody CreatePondResource resource) {
        var createPondCommand = CreatePondCommandFromResourceAssembler.toCommandFromResource(resource);
        var pond = pondCommandService.handle(createPondCommand);
        if (pond.isEmpty()) return ResponseEntity.badRequest().build();
        var pondResource = PondResourceFromEntityAssembler.toResourceFromEntity(pond.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(pondResource);
    }
}
