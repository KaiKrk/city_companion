package com.oc.p12.Entity;

import com.oc.p12.Bean.Dto.Weather.WeatherAirQualityDto;

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
    private Date registeredOn;

    @Column(name = "hour")
    private Time hourOfTheDay;

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
    public Weather(WeatherAirQualityDto weatherAirQualityDto) {
        registeredOn = java.sql.Date.valueOf(weatherAirQualityDto.getRegisteredOn().toLocalDate());
        hourOfTheDay = Time.valueOf(weatherAirQualityDto.getRegisteredOn().toLocalTime());
        temperature = weatherAirQualityDto.getTemperature();
        feelsLikeTemperature = weatherAirQualityDto.getTemperatureFeelsLike();
        city = "Paris";
        precipitationType = weatherAirQualityDto.getPrecipitationType();
        precipirationProbability = weatherAirQualityDto.getPrecipitationProbability();

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(Date registeredOn) {
        this.registeredOn = registeredOn;
    }

    public Time getHourOfTheDay() {
        return hourOfTheDay;
    }

    public void setHourOfTheDay(Time hourOfTheDay) {
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

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", registeredOn=" + registeredOn +
                ", hourOfTheDay=" + hourOfTheDay +
                ", temperature=" + temperature +
                ", feelsLikeTemperature=" + feelsLikeTemperature +
                ", city='" + city + '\'' +
                ", precipitationType='" + precipitationType + '\'' +
                ", precipirationProbability=" + precipirationProbability +
                '}';
    }
}
