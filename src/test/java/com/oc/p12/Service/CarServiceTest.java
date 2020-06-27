package com.oc.p12.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
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
        String carTravelDateJson = carTravelService.getTraficInformation("A", "B");
        System.out.println("B");


    }

}
