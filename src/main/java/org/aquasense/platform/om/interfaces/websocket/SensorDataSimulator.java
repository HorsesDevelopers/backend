package org.aquasense.platform.om.interfaces.websocket;

import org.aquasense.platform.om.application.internal.SensorDataProducer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@EnableScheduling
public class SensorDataSimulator {

    private final SensorDataProducer sensorDataProducer;
    private final Random random = new Random();

    public SensorDataSimulator(SensorDataProducer sensorDataProducer) {
        this.sensorDataProducer = sensorDataProducer;
    }

    @Scheduled(fixedRate = 5000)
    public void generateAndSendSensorData() {
        SensorData sensorData = new SensorData();
        sensorData.setPondId(1L);
        sensorData.setSensorType("temperature");
        sensorData.setValue((float) (20 + random.nextDouble() * 10)); // Temperatura entre 20-30°C

        // Publica en el canal que los clientes están escuchando
        sensorDataProducer.publishSensorData(sensorData);
    }
}
