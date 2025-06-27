package org.aquasense.platform.assets.interfaces;

import org.aquasense.platform.assets.domain.model.commands.CreateSensorCommand;
import org.aquasense.platform.assets.domain.services.SensorCommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/sync")
public class FogController {

    private final SensorCommandService sensorCommandService;

    public FogController(SensorCommandService sensorCommandService) {
        this.sensorCommandService = sensorCommandService;
    }

    @PostMapping
    public ResponseEntity<String> processDeviceData(@RequestBody List<DeviceDataResource> deviceDataResources) {
        // Aquí irían las operaciones necesarias con deviceId, type y value
        // Por ejemplo, guardar en base de datos, procesar, etc.
        int processedCount = 0;

        for (DeviceDataResource data : deviceDataResources) {
            System.out.println("Device ID: " + data.getDevice_Id());
            System.out.println("Type: " + data.getSensor_type());
            System.out.println("Value: " + data.getValue());
            System.out.println("Timestamp: " + data.getTimestamp());
            // Procesamiento de cada registro

            try {
                // Convert device data to sensor command based on sensor type
                int oxygenLevel = 0;
                Float waterTempLevel = 0.0f;

                if ("oxygen".equalsIgnoreCase(data.getSensor_type())) {
                    oxygenLevel = data.getValue() != null ? data.getValue().intValue() : 0;
                } else if ("temperature".equalsIgnoreCase(data.getSensor_type())) {
                    waterTempLevel = data.getValue();
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
        // Aquí podrías llamar a un servicio para procesar los datos
        // Por ejemplo, si tienes un servicio llamado deviceDataService:
        // deviceDataService.processDeviceData(deviceDataResource.getDeviceId(), deviceDataResource.getType(), deviceDataResource.getValue());

        System.out.println("Received Device Data: " + deviceDataResources);



        // Retornamos una respuesta exitosa
        return ResponseEntity.ok("Successfully processed " + processedCount + " of " +
                deviceDataResources.size() + " records");
    }
}
