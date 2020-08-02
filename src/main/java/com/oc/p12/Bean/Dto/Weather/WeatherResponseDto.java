package com.oc.p12.Bean.Dto.Weather;

import com.oc.p12.Entity.Weather;

public class WeatherResponseDto {

    private String date;

    private String hour;

    private double temperature;

    private double feels_like;

    private String precipitationType;

    private int precipitationProbability;

    public WeatherResponseDto(Weather weather) {
        this.date = weather.getRegisteredOn().toString();
        this.hour = weather.getHourOfTheDay().toString();
        this.temperature = weather.getTemperature();
        this.feels_like = weather.getFeelsLikeTemperature();
        this.precipitationType = weather.getPrecipitationType();
        this.precipitationProbability = weather.getPrecipirationProbability();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }

    public String getPrecipitationType() {
        return precipitationType;
    }

    public void setPrecipitationType(String precipitationType) {
        this.precipitationType = precipitationType;
    }

    public int getPrecipitationProbability() {
        return precipitationProbability;
    }

    public void setPrecipitationProbability(int precipitationProbability) {
        this.precipitationProbability = precipitationProbability;
    }
}
