package com.oc.p12.Entity;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weather_id")
    private int id;

    @Column(name = "registered_on")
    private LocalDate registeredOn;

    @Column(name = "hour")
    private LocalTime hourOfTheDay;

    @Column(name = "temperature")
    private double temperature;

    @Column(name = "feels_like")
    private double feelsLikeTemperature;

    @Column(name = "city")
    private String city;

    @Column(name = "precipitation_type")
    private String precipitationType;

    @Column(name = "precipitation_probability")
    private int precipirationProbability;

    public Weather() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
    }

    public LocalTime getHourOfTheDay() {
        return hourOfTheDay;
    }

    public void setHourOfTheDay(LocalTime hourOfTheDay) {
        this.hourOfTheDay = hourOfTheDay;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getFeelsLikeTemperature() {
        return feelsLikeTemperature;
    }

    public void setFeelsLikeTemperature(double feelsLikeTemperature) {
        this.feelsLikeTemperature = feelsLikeTemperature;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPrecipitationType() {
        return precipitationType;
    }

    public void setPrecipitationType(String precipitationType) {
        this.precipitationType = precipitationType;
    }

    public int getPrecipirationProbability() {
        return precipirationProbability;
    }

    public void setPrecipirationProbability(int precipirationProbability) {
        this.precipirationProbability = precipirationProbability;
    }
}
