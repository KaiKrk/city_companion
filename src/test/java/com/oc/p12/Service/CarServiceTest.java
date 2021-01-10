package com.oc.p12.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.oc.p12.Bean.Dto.CarTraffic.CarTravelResponseDto;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CarServiceTest {

    @Autowired
    CarTravelService carTravelService;


    @Test
    public void getCarTravelDatas() throws JsonProcessingException, JSONException {
       String origin ="7 Rue de Chezy 92220 Neuilly-sur-Seine";
       String destination = "7 Rue de L'Union 93400 Saint-Ouen";
        CarTravelResponseDto carTravelDateJson = carTravelService.getTraficInformation(origin, destination);
        System.out.println(carTravelDateJson.normalTrafficTime());
        System.out.println(carTravelDateJson.realTrafficTime());
        System.out.println(carTravelDateJson.distanceAtoB());
        System.out.println(carTravelDateJson.getStatus());

    }



}
