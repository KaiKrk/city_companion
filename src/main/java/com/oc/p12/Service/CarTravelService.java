package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.CarTraffic.CarTravelDto;
import com.oc.p12.Bean.Dto.CarTraffic.CarTravelResponseDto;
import com.oc.p12.Bean.Dto.Dashboard.CarTrafficDashboardDTO;
import com.oc.p12.Entity.Account;
import com.oc.p12.Entity.CarTravel;
import com.oc.p12.Entity.TransportInfo;
import com.oc.p12.Repository.CarTravelInfoRepository;
import com.oc.p12.Repository.CarTravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CarTravelService {

    @Autowired
    CarTravelInfoRepository carTravelInfoRepository;

    @Autowired
    CarTravelRepository carTravelRepository;



    RestTemplate restTemplate = new RestTemplate();
    private String googleMatrixApiUrl = "https://maps.googleapis.com/maps/api/distancematrix/json?units=metric";
    private String originParamater = "&origins=";
    private String destinationParameter = "&destinations=";
    private String googleMatrixApiKey = "&key=AIzaSyCpiSKqhhewAsIYy7uyVtJf7FTX9DhBXoQ";
    private String departureTime = "&departure_time=now";


    public CarTravelResponseDto getTraficInformation(String origin, String destination){
        origin ="41 rue de seine alfortville";
        destination = "krakow";
        ResponseEntity<CarTravelResponseDto> responseEntity =
                restTemplate.getForEntity(googleMatrixApiUrl+originParamater+origin+destinationParameter+destination+googleMatrixApiKey+departureTime, CarTravelResponseDto.class);
        CarTravelResponseDto carTravelResponse = responseEntity.getBody();
      return carTravelResponse;
    }

    public CarTravelDto fetchRealTimeTrafficByAccount(TransportInfo transportInfo){
        CarTravelResponseDto actualTraffic = getTraficInformation(transportInfo.getAccount().getAddress().getAdressToString(), transportInfo.getAccount().getWorkAddress().getAdressToString());
        CarTravel carTravel = new CarTravel(actualTraffic, transportInfo);
        return new CarTravelDto( carTravelRepository.save(carTravel));
    }

    public TransportInfo saveCarTravelInfo(TransportInfo transportInfo){
        return carTravelInfoRepository.save(transportInfo);
    }

    public TransportInfo findCarTravelInfoByAccount(Account account){
        return carTravelInfoRepository.findByAccount(account);
    }

    public CarTravelDto saveCarTravel(CarTravel carTravel){
        return new CarTravelDto(carTravel);
    }

    public CarTravel getCarTravelByCarTravelInfo(TransportInfo transportInfo){
        return carTravelRepository.findByTransportInfo(transportInfo);
    }

    public CarTrafficDashboardDTO getTrafficDashboardDTO(Account account){
        return new CarTrafficDashboardDTO(getTraficInformation(account.getAddress().getAdressToString(), account.getWorkAddress().getAdressToString()), account.getAddress(), account.getWorkAddress());
    }
}
