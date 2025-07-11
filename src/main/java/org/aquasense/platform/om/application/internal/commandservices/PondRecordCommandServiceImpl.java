package org.aquasense.platform.om.application.internal.commandservices;

import org.aquasense.platform.om.application.internal.outboundservices.ExternalAROMService;
import org.aquasense.platform.om.domain.model.aggregates.Pond;
import org.aquasense.platform.om.domain.model.commands.CreateNotificationCommand;
import org.aquasense.platform.om.domain.model.commands.ReceivePondRecordCommand;
import org.aquasense.platform.om.domain.model.entities.PondRecord;
import org.aquasense.platform.om.domain.model.valueobjects.RecordValue;
import org.aquasense.platform.om.domain.services.NotificationCommandService;
import org.aquasense.platform.om.domain.services.PondRecordCommandService;
import org.aquasense.platform.om.infrastructure.persistence.jpa.repositories.PondRecordRepository;
import org.aquasense.platform.om.infrastructure.persistence.jpa.repositories.PondRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PondRecordCommandServiceImpl implements PondRecordCommandService {

    private final PondRecordRepository pondRecordRepository;
    private final ExternalAROMService externalAROMService;
    private final PondRepository pondRepository;
    private final NotificationCommandService notificationCommandService;

    public PondRecordCommandServiceImpl(PondRecordRepository pondRecordRepository, ExternalAROMService externalAROMService, PondRepository pondRepository, NotificationCommandService notificationCommandService) {
        this.pondRecordRepository = pondRecordRepository;
        this.externalAROMService = externalAROMService;
        this.pondRepository = pondRepository;
        this.notificationCommandService = notificationCommandService;
    }

    @Override
    public Optional<PondRecord> handle(ReceivePondRecordCommand command) {
        boolean pondExists = pondRepository.existsById(command.pondId());
        Pond pond;

        if (!pondExists) {
            pond = new Pond();
            pondRepository.save(pond);
        } else {
            pond = pondRepository.findById(command.pondId())
                    .orElseThrow(() -> new IllegalArgumentException("Pond not found"));
        }

        RecordValue recordValue = new RecordValue(command.value(), command.timestamp());

        long sensorId;
        if (!externalAROMService.existSensorByPondIdAndType(command.pondId(), command.recordType())) {
            sensorId = externalAROMService.createSensor(command.pondId(), command.recordType(), command.value(), command.value());
            PondRecord pondRecord = new PondRecord(sensorId);
            pond.addPondRecord(pondRecord);
            pondRecord.addValue(recordValue);

            pondRepository.save(pond);
            checkThresholdAndNotify(command, command.value());
            return Optional.of(pondRecord);
        } else {
            sensorId = externalAROMService.getSensorIdByPondIdAndType(command.pondId(), command.recordType());
            Optional<PondRecord> pondRecordOpt = pondRecordRepository.getPondRecordBySensorId(sensorId);
            if (pondRecordOpt.isPresent()) {
                PondRecord pondRecord = pondRecordOpt.get();
                pondRecord.addValue(recordValue);
                pondRecordRepository.save(pondRecord);
                checkThresholdAndNotify(command, command.value());
                return Optional.of(pondRecord);
            } else {
                return Optional.empty();
            }
        }
    }

    private void checkThresholdAndNotify(ReceivePondRecordCommand command, float value) {
        String type = command.recordType();
        boolean isDanger = false;
        String message = "";

        switch (type) {
            case "Temp":
                if (value < 15.0f || value > 32.0f) {
                    isDanger = true;
                    message = "Temperatura peligrosa para peces: " + value + "°C";
                }
                break;
            case "pH":
                if (value < 6.5f || value > 8.5f) {
                    isDanger = true;
                    message = "pH peligroso para peces: " + value;
                }
                break;
            case "Turbidity":
                if (value > 50.0f) {
                    isDanger = true;
                    message = "Turbidez peligrosa para peces: " + value + " NTU";
                }
                break;
        }

        if (isDanger) {
            CreateNotificationCommand notificationCommand = new CreateNotificationCommand("Peligro", message, command.pondId());
            notificationCommandService.handle(notificationCommand);
        }
    }
}

