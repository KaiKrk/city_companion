package com.oc.p12.Repository;

import com.oc.p12.Entity.AirQuality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AirQualityRepository extends JpaRepository<AirQuality, Integer> {

    public List<AirQuality> findAllByRegisteredOn(Date registeredOn);

    public List<AirQuality> findByDayAndHourOrderByRegisteredOnDesc(Date date, Time time);
}
