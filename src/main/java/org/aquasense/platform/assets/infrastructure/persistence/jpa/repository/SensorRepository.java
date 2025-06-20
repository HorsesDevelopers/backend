package org.aquasense.platform.assets.infrastructure.persistence.jpa.repository;

import org.aquasense.platform.assets.domain.model.aggregates.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor,Long> {
    // Usar consulta JPQL personalizada para evitar problemas de nombres de atributos
    @Query("SELECT s FROM Sensor s WHERE s.createdAt BETWEEN :startDate AND :endDate")
    List<Sensor> findAllByDateRangeBetween(@Param("startDate") LocalDateTime start, @Param("endDate") LocalDateTime end);
}