package com.oc.p12.Repository;

import com.oc.p12.Entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {

    List<Weather> findAllByDate(LocalDate date);
}
