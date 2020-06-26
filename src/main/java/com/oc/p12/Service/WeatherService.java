package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.Weather.WeatherDto;
import com.oc.p12.Entity.Weather;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    RestTemplate restTemplate = new RestTemplate();


    private String weatherApiUrl = "https://api.climacell.co/v3/weather/forecast/hourly?";
    private String weatherApiKey = "apikey=LAUsBhJAeUftlvFsAGlGcsdXzemJaSoN";
    private String parisCoordinates = "&lon=2.3488&lat=48.8534";
    private String extraWeatherAirQualityParameters = "&fields=temp,feels_like,precipitation,precipitation_type,precipitation_probability,pm25,pm10,o3,epa_aqi,epa_health_concern";


    public WeatherDto[] getWeatherDatas(){
        System.out.println("before request");
        ResponseEntity<WeatherDto[]> responseEntity =
                restTemplate.getForEntity(weatherApiUrl+weatherApiKey+ parisCoordinates+extraWeatherAirQualityParameters, WeatherDto[].class);
        WeatherDto[] weatherDatas = responseEntity.getBody();
        System.out.println(weatherDatas.length);
        System.out.println("after request");
        return weatherDatas;
    }

    public String pingService(){
        return "ping";
    }
}
