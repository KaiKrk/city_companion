package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.Weather.WeatherAirQualityDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
public class WeatherServiceTest {

    @Autowired
    WeatherService  weatherService;

    @Test
    public void getWeatherDataTest(){
        WeatherAirQualityDto[] weathers = weatherService.fetchWeatherDatas();
        assertThat(weathers[1].registeredOn.toLocalDate()).isEqualTo(LocalDate.now());
        assertThat(weathers[35].registeredOn.toLocalDate()).isEqualTo(LocalDate.now().plusDays(1));

    }

    @Test
    public void pingTest(){
        LocalDate date =  LocalDate.now();
        LocalTime time = LocalTime.now();
        System.out.println(date);
        System.out.println(time.withMinute(00).withSecond(00).format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
