package com.oc.p12.Repository;

import com.oc.p12.Entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {

    List<Weather> findAllByRegisteredOn(Date date);

    List<Weather> findByDayAndHourOfTheDayOrderByRegisteredOnDesc(Date date, Time hour);
}
