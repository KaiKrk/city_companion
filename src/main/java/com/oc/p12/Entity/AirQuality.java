package com.oc.p12.Entity;

import com.oc.p12.Bean.Dto.Weather.WeatherAirQualityDto;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "air_quality")
public class AirQuality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "air_quality_id")
    private int id;

    @Column(name = "epa_aqi")
    private double epaAqi;

    @Column(name = "epa_health_concern")
    private String epaHealthConcernMessage;

    @Column(name = "pm25")
    private double pm25;

    @Column(name = "pm10")
    private double pm10;

    @Column(name = "o3")
    private double o3;

    @Column(name = "registered_on")
    private Date registeredOn;

    @Column(name = "hour")
    private Time hour;

    public AirQuality() {
    }
    public AirQuality(WeatherAirQualityDto weatherAirQualityDto) {
        epaAqi = weatherAirQualityDto.getEpaAqi();
        epaHealthConcernMessage = weatherAirQualityDto.getEpaHealthConcern();
        pm25 = weatherAirQualityDto.getPm25();
        pm10 = weatherAirQualityDto.getPm10();
        o3 = weatherAirQualityDto.getO3();
        registeredOn = Date.valueOf(weatherAirQualityDto.getRegisteredOn().toLocalDate());
        hour = Time.valueOf(weatherAirQualityDto.getRegisteredOn().toLocalTime());
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getEpaAqi() {
        return epaAqi;
    }

    public void setEpaAqi(int epaAqi) {
        this.epaAqi = epaAqi;
    }

    public String getEpaHealthConcernMessage() {
        return epaHealthConcernMessage;
    }

    public void setEpaHealthConcernMessage(String epaHealthConcernMessage) {
        this.epaHealthConcernMessage = epaHealthConcernMessage;
    }

    public double getPm25() {
        return pm25;
    }

    public void setPm25(double pm25) {
        this.pm25 = pm25;
    }

    public double getPm10() {
        return pm10;
    }

    public void setPm10(double pm10) {
        this.pm10 = pm10;
    }

    public double getO3() {
        return o3;
    }

    public void setO3(double o3) {
        this.o3 = o3;
    }

    public Date getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(Date registeredOn) {
        this.registeredOn = registeredOn;
    }

    public void setEpaAqi(double epaAqi) {
        this.epaAqi = epaAqi;
    }

    public Time getHour() {
        return hour;
    }

    public void setHour(Time hour) {
        this.hour = hour;
    }
}
