package org.aquasense.platform.ar.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class SensorValue {
    private String value;
    private String unit;

    public SensorValue() {}

    public SensorValue(String value, SensorType type) {
        this.value = value;
        switch (type) {
            case Temp -> this.unit = "°C";
            case pH -> this.unit = "pH";
            case Turbidity -> this.unit = "NTU";
        }
    }
}