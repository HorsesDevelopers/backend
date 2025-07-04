package org.aquasense.platform.oam.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.aquasense.platform.oam.domain.model.queries.GetAllNotificationsQuery;
import org.aquasense.platform.oam.domain.services.NotificationCommandService;
import org.aquasense.platform.oam.domain.services.NotificationQueryService;
import org.aquasense.platform.oam.interfaces.rest.resources.CreateNotificationResource;
import org.aquasense.platform.oam.interfaces.rest.resources.NotificationResource;
import org.aquasense.platform.oam.interfaces.rest.transform.CreateNotificationCommandFromResourceAssembler;
import org.aquasense.platform.oam.interfaces.rest.transform.NotificationResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing notifications.
 */
@RestController
@RequestMapping(value = "api/v1/notifications", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Notifications", description = "Available Notification Endpoints")
public class NotificationsController {

    private final NotificationCommandService notificationCommandService;
    private final NotificationQueryService notificationQueryService;


    public NotificationsController(NotificationCommandService notificationCommandService, NotificationQueryService notificationQueryService) {
        this.notificationCommandService = notificationCommandService;
        this.notificationQueryService = notificationQueryService;
    }

    @GetMapping
    @Operation(summary = "Get All Notifications")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notifications Found"),
            @ApiResponse(responseCode = "400", description = "Notifications Not Found"),
    })
    public ResponseEntity<List<NotificationResource>> getAllNotifications() {
        var notifications = notificationQueryService.handle(new GetAllNotificationsQuery());
        if (notifications.isEmpty()) return ResponseEntity.notFound().build();
        var notificationsResource =  notifications.stream()
                .map(NotificationResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(notificationsResource);
    }

    /**
     * Create a new notification
     * @param resource The {@link CreateNotificationResource} instance
     * @return A {@link NotificationResource} resource for the created notification, or bad request if the notification could not be created.
     */
    @PostMapping
    @Operation(summary = "Create Notification")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Notification Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
    })
    public ResponseEntity<NotificationResource> createNotification(@RequestBody CreateNotificationResource resource) {
        var createNotificationCommand = CreateNotificationCommandFromResourceAssembler.toCommandFromResource(resource);
        var notification = notificationCommandService.handle(createNotificationCommand);
        if (notification.isEmpty()) return ResponseEntity.badRequest().build();
        var notificationResource = NotificationResourceFromEntityAssembler.toResourceFromEntity(notification.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(notificationResource);
    }
}
