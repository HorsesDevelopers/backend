package org.aquasense.platform.om.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.aquasense.platform.om.domain.model.aggregates.Pond;
import org.aquasense.platform.om.domain.model.valueobjects.RecordValue;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class PondRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long sensorId;

    @ManyToOne
    @JoinColumn(name = "pond_id")
    private Pond pond;

    @ElementCollection
    private List<RecordValue> values;

    public PondRecord(){
        this.values = new ArrayList<>();
    }

    public PondRecord(Long sensorId) {
        this();
        this.sensorId = sensorId;
    }

    public void addValue(RecordValue value) {
        this.values.add(value);
    }

    public void removeValue(RecordValue value) {
        this.values.remove(value);
    }
}