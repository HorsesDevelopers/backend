package org.aquasense.platform.om.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Embeddable
public class RecordValue {
    private float value;
    private Date receivedAt;

    public RecordValue(float value, Date receivedAt) {
        this.value = value;
        this.receivedAt = receivedAt;
    }
}