package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.Weather.WeatherAirQualityDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class WeatherServiceTest {

    @Autowired
    WeatherService  weatherService;

    @Test
    public void getWeatherDataTest(){
        WeatherAirQualityDto[] weathers = weatherService.fetchWeatherDatas();
        int length = weathers.length;
        for (int i = 0; i <= length-1; i++){
            System.out.println(weathers[i]);
        }
    }

    @Test
    public void pingTest(){
        LocalDate date =  LocalDate.now();
        System.out.println(date);
    }
}
