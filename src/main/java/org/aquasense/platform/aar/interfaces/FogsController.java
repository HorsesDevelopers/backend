package org.aquasense.platform.aar.interfaces;

import org.aquasense.platform.aar.domain.model.commands.CreateSensorCommand;
import org.aquasense.platform.aar.domain.services.SensorCommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/fogs")
public class FogsController {

    private final SensorCommandService sensorCommandService;

    public FogsController(SensorCommandService sensorCommandService) {
        this.sensorCommandService = sensorCommandService;
    }

    @PostMapping
    public ResponseEntity<String> processDeviceData(@RequestBody List<DeviceDataResource> deviceDataResources) {

        // Here would go the necessary operations with deviceId, type and value
        // For example, saving to database, processing, etc.
        int processedCount = 0;

        for (DeviceDataResource data : deviceDataResources) {
            System.out.println("Device ID: " + data.getDevice_Id());
            System.out.println("Type: " + data.getSensor_type());
            System.out.println("Value: " + data.getValue());
            System.out.println("Timestamp: " + data.getTimestamp());
            // Processing each record

            try {
                // Convert device data to sensor command based on sensor type
                int oxygenLevel = 0;
                Float waterTempLevel = 0.0f;

                if ("oxygen".equalsIgnoreCase(data.getSensor_type()) && data.getValue() != null) {
                    try {
                        oxygenLevel = Integer.parseInt(data.getValue());
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid oxygen value format: " + data.getValue());
                    }
                } else if ("temperature".equalsIgnoreCase(data.getSensor_type()) && data.getValue() != null) {
                    try {
                        waterTempLevel = Float.parseFloat(data.getValue());
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid temperature value format: " + data.getValue());
                    }
                }

                CreateSensorCommand command = new CreateSensorCommand(
                        oxygenLevel,
                        data.getSensor_type(),
                        data.getStatus(),
                        waterTempLevel
                );

                // Save sensor using command service
                sensorCommandService.handle(command);
                processedCount++;

            } catch (Exception e) {
                System.err.println("Error saving sensor data: " + e.getMessage());
            }
        }
        // Here you could call a service to process the data
        // For example, if you have a service called deviceDataService:
        // deviceDataService.processDeviceData(deviceDataResource.getDeviceId(), deviceDataResource.getType(), deviceDataResource.getValue());

        System.out.println("Received Device Data: " + deviceDataResources);



        // Return a response indicating success
        return ResponseEntity.ok("Successfully processed " + processedCount + " of " +
                deviceDataResources.size() + " records");
    }
}
