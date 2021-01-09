package com.oc.p12.Bean.Dto.Dashboard;

import com.oc.p12.Entity.Weather;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class WeatherDashboardDto {

    public String rain;
    public int rainProbability;
    public double temperature;
    public double feelsLike;

    public WeatherDashboardDto(Weather weather) {
        this.rain = weather.getPrecipitationType();
        this.rainProbability = weather.getPrecipirationProbability();
        this.temperature = weather.getTemperature();
        this.feelsLike = weather.getFeelsLikeTemperature();
    }
}
