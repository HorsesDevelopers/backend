package org.aquasense.platform.sdp.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aquasense.platform.sdp.domain.model.commands.CreateScheduleCommand;
import org.aquasense.platform.sdp.domain.model.valueobjects.OpenDuration;
import org.aquasense.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="schedules")
public class Schedule extends AuditableAbstractAggregateRoot<Schedule> {

  private String name;
  private Long pondId;

  private LocalDate day;
  private LocalTime hour;

  private OpenDuration duration;

  public Schedule(CreateScheduleCommand command) {
    this.name = command.name();
    this.pondId = command.pondId();
    this.day = command.day();
    this.hour = command.hour();
    this.duration = command.duration();
  }

}
