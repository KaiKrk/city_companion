package com.oc.p12.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "air_quality")
public class AirQuality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "air_quality_id")
    private int id;

    @Column(name = "epa_aqi")
    private int epaAqi;

    @Column(name = "epa_health_concern")
    private String epaHealthConcernMessage;

    @Column(name = "pm25")
    private double pm25;

    @Column(name = "pm10")
    private double pm10;

    @Column(name = "o3")
    private double o3;

    @Column(name = "registered_on")
    private LocalDateTime registeredOn;

    public AirQuality() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEpaAqi() {
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

    public LocalDateTime getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDateTime registeredOn) {
        this.registeredOn = registeredOn;
    }
}
