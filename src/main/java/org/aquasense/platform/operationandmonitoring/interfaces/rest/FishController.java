package org.aquasense.platform.operationandmonitoring.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.aquasense.platform.operationandmonitoring.domain.model.queries.GetAllFishQuery;
import org.aquasense.platform.operationandmonitoring.domain.services.FishCommandService;
import org.aquasense.platform.operationandmonitoring.domain.services.FishQueryService;
import org.aquasense.platform.operationandmonitoring.interfaces.rest.resources.CreateFishResource;
import org.aquasense.platform.operationandmonitoring.interfaces.rest.resources.FishResource;
import org.aquasense.platform.operationandmonitoring.interfaces.rest.transform.CreateFishCommandFromResourceAssembler;
import org.aquasense.platform.operationandmonitoring.interfaces.rest.transform.FishResourceFromEntityAssembler;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/fishes", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Fish", description = "Available Fish Endpoints")
public class FishController {

    private final FishCommandService fishCommandService;
    private final FishQueryService fishQueryService;


    public FishController(FishCommandService fishCommandService, FishQueryService fishQueryService) {
        this.fishCommandService = fishCommandService;
        this.fishQueryService = fishQueryService;
    }


    @GetMapping
    @Operation(summary = "Get All Fishes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fishes Found"),
            @ApiResponse(responseCode = "400", description = "Fishes Not Found"),
    })
    public ResponseEntity<List<FishResource>> getAllFishes() {
        var fishes = fishQueryService.handle(new GetAllFishQuery());
        if (fishes.isEmpty()) return ResponseEntity.notFound().build();
        var fishesResource = fishes.stream()
                .map(FishResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(fishesResource);
    }

    @PostMapping
    @Operation(summary = "Create Fish")
    public ResponseEntity<FishResource> createFish(@RequestBody CreateFishResource resource) {
        var createFishCommand = CreateFishCommandFromResourceAssembler.toCommandFromResource(resource);
        var fish = fishCommandService.handle(createFishCommand);
        if (fish.isEmpty()) return ResponseEntity.badRequest().build();
        var fishResource = FishResourceFromEntityAssembler.toResourceFromEntity(fish.get());
        return ResponseEntity.ok(fishResource);
    }

}
