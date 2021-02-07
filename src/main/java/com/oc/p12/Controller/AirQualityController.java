package com.oc.p12.Controller;

import com.oc.p12.Bean.Dto.Weather.AirQualityResponseDto;
import com.oc.p12.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for AirQuality entity
 */
@CrossOrigin("http://localhost:4200")
@RestController
public class AirQualityController {

    @Autowired
    WeatherService weatherService;

    /**
     * method that fetch airQuality datas on Climacell API
     * @return response of Climacell Rest API
     */
    @GetMapping("/airQuality")
    public List<AirQualityResponseDto> getAirQualityDatas(){
        return weatherService.getAirQualityDataOfTheDay();
    }
}
