package org.aquasense.platform.om.application.internal;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class SensorDataProducer {

    private final SimpMessagingTemplate messagingTemplate;

    public SensorDataProducer(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    // Este método puede ser llamado desde cualquier parte de tu aplicación
    // para enviar datos a los clientes suscritos
    public void publishSensorData(Object sensorData) {
        messagingTemplate.convertAndSend("/topic/sensors", sensorData);
    }
}
