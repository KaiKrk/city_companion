package com.oc.p12.Bean.Dto.Dashboard;

import com.oc.p12.Entity.Weather;
import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Data
@ToString
public class WeatherDashboardDto {

    public String rain;
    public int rainProbability;
    public double temperature;
    public double feelsLike;

    public WeatherDashboardDto(Weather weather) {
        Map<String,String> precipitationType = getPrecipationType();
        System.out.println(weather.getPrecipitationType());
        this.rain = precipitationType.get(weather.getPrecipitationType());
        this.rainProbability = weather.getPrecipirationProbability();
        this.temperature = weather.getTemperature();
        this.feelsLike = weather.getFeelsLikeTemperature();
    }

    Map<String,String> getPrecipationType(){
        Map<String,String> precipitationType = new HashMap<>();
        precipitationType.put("none", "Pas de Pluie");
        precipitationType.put("rain", "Risque de Pluie");
        precipitationType.put("snow", "Risque de Neige");
        precipitationType.put("freezing rain", "Risque de Pluie Verglacante");
        return precipitationType;
    }
}
