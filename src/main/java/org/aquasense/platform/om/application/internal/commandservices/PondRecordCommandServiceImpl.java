package org.aquasense.platform.om.application.internal.commandservices;

import org.aquasense.platform.om.application.internal.outboundservices.ExternalAROMService;
import org.aquasense.platform.om.domain.model.aggregates.Pond;
import org.aquasense.platform.om.domain.model.commands.ReceivePondRecordCommand;
import org.aquasense.platform.om.domain.model.entities.PondRecord;
import org.aquasense.platform.om.domain.model.valueobjects.RecordValue;
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

    public PondRecordCommandServiceImpl(PondRecordRepository pondRecordRepository, ExternalAROMService externalAROMService, PondRepository pondRepository) {
        this.pondRecordRepository = pondRecordRepository;
        this.externalAROMService = externalAROMService;
        this.pondRepository = pondRepository;
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
            pondRecordRepository.save(pondRecord);
            return Optional.of(pondRecord);
        } else {
            sensorId = externalAROMService.getSensorIdByPondIdAndType(command.pondId(), command.recordType());
            Optional<PondRecord> pondRecordOpt = pondRecordRepository.getPondRecordBySensorId(sensorId);
            if (pondRecordOpt.isPresent()) {
                PondRecord pondRecord = pondRecordOpt.get();
                pondRecord.addValue(recordValue);
                pondRecordRepository.save(pondRecord);
                return Optional.of(pondRecord);
            } else {
                return Optional.empty();
            }
        }
    }
}
