package com.oc.p12.Controller;

import com.oc.p12.Bean.Dto.Weather.WeatherResponseDto;
import com.oc.p12.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/weatherDatas")
    public List<WeatherResponseDto> getWeatherDatas(){
        return weatherService.getWeatherDataOfTheDay();
    }

    @GetMapping("/collect")
    public void fetchingDatas(){
        weatherService.fetchWeatherDatas();
    }


}
