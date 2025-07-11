package org.aquasense.platform.om.interfaces.websocket;


import org.aquasense.platform.om.interfaces.websocket.data.SensorData;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SensorsWebSocketController {
    @MessageMapping("/sensor")
    @SendTo("/topic/sensors")
    public SensorData processSensorData(SensorData sensorData) {
        System.out.println("Datos recibidos del sensor: " + sensorData);
        return sensorData;
    }
}

