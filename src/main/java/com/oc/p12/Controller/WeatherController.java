package com.oc.p12.Controller;

import com.oc.p12.Bean.Dto.Weather.WeatherResponseDto;
import com.oc.p12.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * controller that fetch weather datas on climacell API
 */
@CrossOrigin("http://localhost:4200")
@RestController
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    /**
     * get today's weather data
     * @return list of weather data
     */
    @GetMapping("/weatherDatas")
    public List<WeatherResponseDto> getWeatherDatas(){
        return weatherService.getWeatherDataOfTheDay();
    }

    /**
     * collect data from climacell API
     */
    @GetMapping("/collect")
    public void fetchingDatas(){
        weatherService.fetchWeatherDatas();
    }


}
