package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.Weather.WeatherAirQualityDto;
import com.oc.p12.Bean.Dto.Weather.WeatherResponseDto;
import com.oc.p12.Entity.AirQuality;
import com.oc.p12.Entity.Weather;
import com.oc.p12.Repository.AirQualityRepository;
import com.oc.p12.Repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    WeatherRepository weatherRepository;

    @Autowired
    AirQualityRepository airQualityRepository;


    private String weatherApiUrl = "https://api.climacell.co/v3/weather/forecast/hourly?";
    private String weatherApiKey = "apikey=LAUsBhJAeUftlvFsAGlGcsdXzemJaSoN";
    private String parisCoordinates = "&lon=2.3488&lat=48.8534";
    private String extraWeatherAirQualityParameters = "&fields=temp,feels_like,precipitation,precipitation_type,precipitation_probability,pm25,pm10,o3,epa_aqi,epa_health_concern";


    public WeatherAirQualityDto[] fetchWeatherDatas(){
        System.out.println("before request");
        ResponseEntity<WeatherAirQualityDto[]> responseEntity =
                restTemplate.getForEntity(weatherApiUrl+weatherApiKey+ parisCoordinates+extraWeatherAirQualityParameters, WeatherAirQualityDto[].class);
        WeatherAirQualityDto[] weatherDatas = responseEntity.getBody();
        System.out.println(weatherDatas.length);
        System.out.println("after request");
        return weatherDatas;
    }

    public void saveWeatherData(WeatherAirQualityDto[] weatherAirQualityDtos){
        for (WeatherAirQualityDto weatherAirQualityDto : weatherAirQualityDtos
             ) {
            Weather newWeatherData = new Weather(weatherAirQualityDto);
            AirQuality newAirQuality = new AirQuality(weatherAirQualityDto);
            weatherRepository.save(newWeatherData);
            airQualityRepository.save(newAirQuality);

        }

    }

    public List<WeatherResponseDto> getWeatherDataOfTheDay(){
        List<WeatherResponseDto> weatherResponseDtos = new ArrayList<>();
        List<Weather> weatherDatasOfTheDay = weatherRepository.findAllByDate(LocalDate.now());
        for (Weather weather : weatherDatasOfTheDay
                ) {
            WeatherResponseDto weatherResponse = new WeatherResponseDto(weather);
            weatherResponseDtos.add(weatherResponse);
        }
        return  weatherResponseDtos;
    }




}
