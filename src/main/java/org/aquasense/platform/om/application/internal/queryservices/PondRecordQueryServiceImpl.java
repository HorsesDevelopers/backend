package org.aquasense.platform.om.application.internal.queryservices;

import org.aquasense.platform.om.domain.model.entities.PondRecord;
import org.aquasense.platform.om.domain.model.queries.GetPondRecordBySensorIdQuery;
import org.aquasense.platform.om.domain.services.PondRecordQueryService;
import org.aquasense.platform.om.infrastructure.persistence.jpa.repositories.PondRecordRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PondRecordQueryServiceImpl implements PondRecordQueryService {

    private final PondRecordRepository pondRecordRepository;

    public PondRecordQueryServiceImpl(PondRecordRepository pondRecordRepository) {
        this.pondRecordRepository = pondRecordRepository;
    }

    @Override
    public Optional<PondRecord> handle(GetPondRecordBySensorIdQuery query) {
        return pondRecordRepository.getPondRecordBySensorId(query.sensorId());
    }
}
