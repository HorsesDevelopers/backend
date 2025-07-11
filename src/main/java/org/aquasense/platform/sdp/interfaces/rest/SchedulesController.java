package org.aquasense.platform.sdp.interfaces.rest;

import org.aquasense.platform.sdp.domain.model.queries.GetAllSchedulesQuery;
import org.aquasense.platform.sdp.domain.model.queries.GetScheduleByIdQuery;
import org.aquasense.platform.sdp.domain.services.ScheduleCommandService;
import org.aquasense.platform.sdp.domain.services.ScheduleQueryService;
import org.aquasense.platform.sdp.interfaces.rest.resources.CreateScheduleResource;
import org.aquasense.platform.sdp.interfaces.rest.resources.ScheduleResource;
import org.aquasense.platform.sdp.interfaces.rest.resources.UpdateScheduleResource;
import org.aquasense.platform.sdp.interfaces.rest.transform.CreateScheduleCommandFromResourceAssembler;
import org.aquasense.platform.sdp.interfaces.rest.transform.ScheduleResourceFromEntityAssembler;
import org.aquasense.platform.sdp.interfaces.rest.transform.UpdateScheduleCommandFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schedules")
public class SchedulesController {
    private final ScheduleCommandService scheduleCommandService;
    private final ScheduleQueryService scheduleQueryService;

    public SchedulesController(ScheduleCommandService scheduleCommandService, ScheduleQueryService scheduleQueryService){
        this.scheduleCommandService = scheduleCommandService;
        this.scheduleQueryService = scheduleQueryService;
    }

    @PostMapping
    public ResponseEntity<ScheduleResource> createSchedule(@RequestBody CreateScheduleResource createScheduleResource){
        var createScheduleCommand = CreateScheduleCommandFromResourceAssembler.toCommandFromResource(createScheduleResource);
        var scheduleId = scheduleCommandService.handle(createScheduleCommand);

        if (scheduleId == 0L){
            return ResponseEntity.badRequest().build();
        }
        var getScheduleByIdQuery = new GetScheduleByIdQuery(scheduleId);
        var schedule = scheduleQueryService.handle(getScheduleByIdQuery);

        if (schedule.isEmpty())
            return ResponseEntity.badRequest().build();
        var scheduleResource = ScheduleResourceFromEntityAssembler.toResourceFromEntity(schedule.get());
        return new ResponseEntity<>(scheduleResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResource>> getAllSchedules(){
        var getAllSchedulesQuery = new GetAllSchedulesQuery();
        var schedules = scheduleQueryService.handle(getAllSchedulesQuery);
        var scheduleResources= schedules.stream().map(ScheduleResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(scheduleResources);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResource> getScheduleById(@PathVariable Long id){
        var getScheduleByIdQuery = new GetScheduleByIdQuery(id);
        var schedule = scheduleQueryService.handle(getScheduleByIdQuery);

        if (schedule.isEmpty())
            return ResponseEntity.badRequest().build();
        var scheduleResource = ScheduleResourceFromEntityAssembler.toResourceFromEntity(schedule.get());
        return ResponseEntity.ok(scheduleResource);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<ScheduleResource> updateSchedule(@PathVariable Long id, @RequestBody UpdateScheduleResource updateScheduleResource){
//        var updateScheduleCommand = UpdateScheduleCommandFromResourceAssembler.toCommandFromResource(id,updateScheduleResource);
//        var updatedSchedule = scheduleCommandService.handle(updateScheduleCommand);
//
//        if(updatedSchedule.isEmpty()){
//            return ResponseEntity.badRequest().build();
//        }
//        var scheduleResource = ScheduleResourceFromEntityAssembler.toResourceFromEntity(updatedSchedule.get());
//        return ResponseEntity.ok(scheduleResource);
//    }
}
