package com.oc.p12.Bean.Dto.Weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.annotations.SerializedName;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.converter.HttpMessageConversionException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

public class WeatherDto {

    public String precipitationType;

    public LocalDateTime registeredOn;

    public double temperature;

    public double temperatureFeelsLike;

    public int precipitationProbability;

    public double epaAqi;

    public double pm25;

    public double pm10;

    public double o3;

    public String epaHealthConcern;


    public String getPrecipitationType() {
        return precipitationType;
    }

    public void setPrecipitationType(String precipitationType) {
        this.precipitationType = precipitationType;
    }

    public LocalDateTime getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDateTime registeredOn) {
        this.registeredOn = registeredOn;
    }

    public WeatherDto() {
    }

    public  String truncate(String value, int length)
    {
        if (value != null && value.length() > length)
            value = value.substring(0, length);
        return value;
    }

    @Override
    public String toString() {
        return "WeatherDto{" +
                "precipitationType='" + precipitationType + '\'' +
                ", registeredOn=" + registeredOn +
                ", temperature=" + temperature +
                ", temperatureFeelsLike=" + temperatureFeelsLike +
                ", precipitationProbability=" + precipitationProbability +
                ", epaAqi=" + epaAqi +
                ", pm25=" + pm25 +
                ", pm10=" + pm10 +
                ", o3=" + o3 +
                ", epaHealthConcern='" + epaHealthConcern + '\'' +
                '}';
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("precipitation_type")
    private void unpackNested(Map<String,Object> precipitation) {
        System.out.println(precipitation.get("value"));
        this.precipitationType = (String)precipitation.get("value");

    }

    @JsonProperty("precipitation_probability")
    private void unpackNestedPrecipitationProbability(Map<String,Object> precipitationProbability){
        this.precipitationProbability = (int)precipitationProbability.get("value");
    }

    @JsonProperty("observation_time")
    private void unpackNestedObservationTime(Map<String,Object> observationTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String obervationTime = (String) observationTime.get("value");
        this.registeredOn = LocalDateTime.parse(truncate(obervationTime,22));
    }

    @JsonProperty("temp")
    private void unpackNestedTemp(Map<String,Object> temperature){
        System.out.println("temp " +temperature.get("value"));
        try {
            this.temperature = (double)temperature.get("value");
        } catch (Exception exception){
            int temperatureI = (int)temperature.get("value");
            double temperatureD = temperatureI;
            this.temperature = temperatureD;
        }

    }

    @JsonProperty("feels_like")
    private void unpackNestedTempFL(Map<String,Object> temperature){
        System.out.println("Fl" + temperature.get("value"));
        try {
            this.temperatureFeelsLike = (double)temperature.get("value");
        } catch (Exception exception){
            int temperatureI = (int)temperature.get("value");
            double temperatureD = temperatureI;
            this.temperatureFeelsLike = temperatureD;
        }
    }

    @JsonProperty("pm25")
    private void unpackNestedPm25(Map<String,Object> pm25){
        System.out.println(pm25.get("value"));
        if (pm25.get("value") != null){
            try{
                this.pm25 = (double)pm25.get("value");
            }catch (Exception e){
                int pm25I = (int)pm25.get("value");
                double pm25D = pm25I;
                this.pm25 = pm25D;
            }
        }
    }
    @JsonProperty("pm10")
    private void unpackNestedPm10(Map<String,Object>pm10){
        System.out.println(pm10.get("value"));
        if (pm10.get("value") != null){
            try{
                this.pm10 = (double)pm10.get("value");
            }catch (Exception e){
                int pm10I = (int)pm10.get("value");
                double pm10D = pm10I;
                this.pm10 = pm10D;
            }
        }
    }

    @JsonProperty("o3")
    private void unpackedNestedO3(Map<String,Object>o3){
        System.out.println(o3.get("value"));
        if (o3.get("value") != null){
            try{
                this.o3 = (double)o3.get("value");
            }catch (Exception e){
                int o3I = (int)o3.get("value");
                double o3D = o3I;
                this.o3 = o3D;
            }
        }
    }

    @JsonProperty("epa_aqi")
    private void unpackNestedEpaAqi(Map<String,Object> epaAqi){
        System.out.println("epaAqi " + epaAqi.get("value"));
        if (epaAqi.get("value") != null){
            try{
                this.epaAqi = (double)epaAqi.get("value");
            }catch (Exception e){
                int epaAqiI = (int)epaAqi.get("value");
                double epaAqiD = epaAqiI;
                this.epaAqi = epaAqiD;
            }
        }

    }

    @JsonProperty("epa_health_concern")
    private void unpackNestedEpaHealthConcern(Map<String,Object> epaHealthConcern){
        this.epaHealthConcern = (String)epaHealthConcern.get("value");
    }

}
