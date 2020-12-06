package com.oc.p12.Controller;

import com.oc.p12.Bean.Dto.Weather.AirQualityResponseDto;
import com.oc.p12.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
public class AirQualityController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/airQuality")
    public List<AirQualityResponseDto> getAirQualityDatas(){
        return weatherService.getAirQualityDataOfTheDay();
    }
}
