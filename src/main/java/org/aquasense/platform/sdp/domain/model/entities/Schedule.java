package org.aquasense.platform.sdp.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="schedules")
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

  private int loopC;

  private String sensorConditionA;

  private String sensorConditionB;

  private String comment;

  public Schedule(String name, String species, int size, int mass, String foodKind, int foodWeight, int loopC, String sensorConditionA, String sensorConditionB, String comment) {
    this.name = name;
    this.species = species;
    this.size = size;
    this.mass = mass;
    this.foodKind = foodKind;
    this.foodWeight = foodWeight;
    this.loopC = loopC;
    this.sensorConditionA = sensorConditionA;
    this.sensorConditionB = sensorConditionB;
    this.comment = comment;
  }

  public Schedule updatedInformation(String name, String species, int size, int mass, String foodKind, int foodWeight, int loopC, String sensorConditionA, String sensorConditionB, String comment){
    this.name = name;
    this.species = species;
    this.size = size;
    this.mass = mass;
    this.foodKind = foodKind;
    this.foodWeight = foodWeight;
    this.loopC = loopC;
    this.sensorConditionA = sensorConditionA;
    this.sensorConditionB = sensorConditionB;
    this.comment = comment;
    return this;
  }

}
