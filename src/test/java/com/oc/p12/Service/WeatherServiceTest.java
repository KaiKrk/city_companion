package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.Weather.WeatherDto;
import com.oc.p12.Entity.Weather;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WeatherServiceTest {

    @Autowired
    WeatherService  weatherService;

    @Test
    public void getWeatherDataTest(){
        WeatherDto[] weathers = weatherService.getWeatherDatas();
        int length = weathers.length;
        for (int i = 0; i <= length-1; i++){
            System.out.println(weathers[i]);
        }
    }

    @Test
    public void pingTest(){
        String pong = weatherService.pingService();
        System.out.println(pong);
    }
}
