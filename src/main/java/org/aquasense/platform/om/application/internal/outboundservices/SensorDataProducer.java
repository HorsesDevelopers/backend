package org.aquasense.platform.om.application.internal.outboundservices;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class SensorDataProducer {

    private final SimpMessagingTemplate messagingTemplate;

    public SensorDataProducer(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void publishSensorData(Object sensorData) {
        messagingTemplate.convertAndSend("/topic/sensors", sensorData);
    }
}
