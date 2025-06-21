package org.aquasense.platform.sdp.interfaces.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/sync")
public class FogController {

    @PostMapping
    public ResponseEntity<String> processDeviceData(@RequestBody List<DeviceDataResource> deviceDataResources) {
        // Aquí irían las operaciones necesarias con deviceId, type y value
        // Por ejemplo, guardar en base de datos, procesar, etc.

        for (DeviceDataResource data : deviceDataResources) {
            System.out.println("Device ID: " + data.getDeviceId());
            System.out.println("Type: " + data.getType());
            System.out.println("Value: " + data.getValue());
            // Procesamiento de cada registro
        }
        // Aquí podrías llamar a un servicio para procesar los datos
        // Por ejemplo, si tienes un servicio llamado deviceDataService:
        // deviceDataService.processDeviceData(deviceDataResource.getDeviceId(), deviceDataResource.getType(), deviceDataResource.getValue());

        System.out.println("Received Device Data: " + deviceDataResources);

        // Retornamos una respuesta exitosa
        return ResponseEntity.ok("success");
    }
}
