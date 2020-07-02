package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.CarTraffic.CarTravelResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CarTravelService {

    RestTemplate restTemplate = new RestTemplate();
    private String googleMatrixApiUrl = "https://maps.googleapis.com/maps/api/distancematrix/json?units=metric";
    private String originParamater = "&origins=";
    private String destinationParameter = "&destinations=";
    private String googleMatrixApiKey = "&key=AIzaSyCpiSKqhhewAsIYy7uyVtJf7FTX9DhBXoQ";
    private String departureTime = "&departure_time=now";


    public CarTravelResponseDto getTraficInformation(String origin, String destination){
        origin ="41 rue de seine alfortville";
        destination = "la defense";
        ResponseEntity<CarTravelResponseDto> responseEntity =
                restTemplate.getForEntity(googleMatrixApiUrl+originParamater+origin+destinationParameter+destination+googleMatrixApiKey+departureTime, CarTravelResponseDto.class);
        System.out.println("response " + responseEntity);
        CarTravelResponseDto carTravelResponse = responseEntity.getBody();
      return carTravelResponse;
    }


}
