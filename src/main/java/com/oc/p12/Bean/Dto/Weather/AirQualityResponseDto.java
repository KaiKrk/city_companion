package com.oc.p12.Bean.Dto.Weather;

import com.oc.p12.Entity.AirQuality;

public class AirQualityResponseDto {

    public double epaAqi;

    public double pm25;

    public double pm10;

    public double o3;

    public String epaHealthConcern;

    public AirQualityResponseDto() {
    }

    public AirQualityResponseDto(AirQuality airQuality){
        this.epaAqi = airQuality.getEpaAqi();
        this.pm25 = airQuality.getPm25();
        this.pm10 = airQuality.getPm10();
        this.o3 = airQuality.getO3();
        this.epaHealthConcern = airQuality.getEpaHealthConcernMessage();
    }

    public double getEpaAqi() {
        return epaAqi;
    }

    public void setEpaAqi(double epaAqi) {
        this.epaAqi = epaAqi;
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

    public String getEpaHealthConcern() {
        return epaHealthConcern;
    }

    public void setEpaHealthConcern(String epaHealthConcern) {
        this.epaHealthConcern = epaHealthConcern;
    }
}
