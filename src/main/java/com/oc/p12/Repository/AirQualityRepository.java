package com.oc.p12.Repository;

import com.oc.p12.Entity.AirQuality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AirQualityRepository extends JpaRepository<AirQuality, Integer> {

    public List<AirQuality> findAllByRegisteredOn(LocalDate registeredOn);
}
