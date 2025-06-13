package org.aquasense.platform.schedule.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Schedule")
public class Schedule {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String species;

  private int size;

  private int mass;

  private String foodKind;

  private int foodWeight;

  private int loop;

  private String sensorCondition;

  private String comment;

  public Schedule(String name, String species, int size, int mass, String foodKind, int foodWeight, int loop, String sensorCondition, String comment) {
    this.name = name;
    this.species = species;
    this.size = size;
    this.mass = mass;
    this.foodKind = foodKind;
    this.foodWeight = foodWeight;
    this.loop = loop;
    this.sensorCondition = sensorCondition;
    this.comment = comment;
  }

}
