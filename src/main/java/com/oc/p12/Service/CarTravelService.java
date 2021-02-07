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

/**
 * service for car travel entity
 */
@Service
public class CarTravelService {

    @Autowired
    CarTravelInfoRepository carTravelInfoRepository;

    @Autowired
    CarTravelRepository carTravelRepository;

    @Autowired
    AccountService accountService;


    /**
     * initializing google matrix api constant
     */
    RestTemplate restTemplate = new RestTemplate();
    private String googleMatrixApiUrl = "https://maps.googleapis.com/maps/api/distancematrix/json?units=metric";
    private String originParamater = "&origins=";
    private String destinationParameter = "&destinations=";
    private String googleMatrixApiKey = "&key=AIzaSyCpiSKqhhewAsIYy7uyVtJf7FTX9DhBXoQ";
    private String departureTime = "&departure_time=now";

    /**
     * retrieve trafic information with origin and destination as parameter
     *
     * @param origin
     * @param destination
     * @return matrix api response json in a dto
     */
    public CarTravelResponseDto getTraficInformation(String origin, String destination){

        ResponseEntity<CarTravelResponseDto> responseEntity =
                restTemplate.getForEntity(googleMatrixApiUrl+originParamater+origin+destinationParameter+destination+googleMatrixApiKey+departureTime, CarTravelResponseDto.class);
        CarTravelResponseDto carTravelResponse = responseEntity.getBody();
      return carTravelResponse;
    }

    /**
     * retrieve real time traffic informations for an account
     * @param transportInfo
     * @return carTravelDTO
     */
    public CarTravelDto fetchRealTimeTrafficByAccount(TransportInfo transportInfo){
        CarTravelResponseDto actualTraffic = getTraficInformation(transportInfo.getAccount().getAddress().getAdressToString(), transportInfo.getAccount().getWorkAddress().getAdressToString());
        CarTravel carTravel = new CarTravel(actualTraffic, transportInfo);
        return new CarTravelDto( carTravelRepository.save(carTravel));
    }

    /**
     * save the transport informations
     * @param transportInfo
     * @return update transport informations
     */
    public TransportInfo saveCarTravelInfo(TransportInfo transportInfo){
        return carTravelInfoRepository.save(transportInfo);
    }

    /**
     * get the travel informations for an account
     * @param account
     * @return  TransportInfo
     */
    public TransportInfo findCarTravelInfoByAccount(Account account){
        return carTravelInfoRepository.findByAccount(account);
    }

    /**
     * save the car Travel info
     * @param carTravel
     * @return carTravelDTO
     */
    public CarTravelDto saveCarTravel(CarTravel carTravel){
        return new CarTravelDto(carTravel);
    }

    /**
     * get previous travels by account info
     * @param transportInfo
     * @return
     */
    public CarTravel getCarTravelByCarTravelInfo(TransportInfo transportInfo){
        return carTravelRepository.findByTransportInfo(transportInfo);
    }

    /**
     * get traffic datas for dashboard display
     * @param accountId
     * @return car traffic informations in the dashboard format
     */
    public CarTrafficDashboardDTO getTrafficDashboardDTO(int accountId){
        Account account = accountService.findById(accountId);
        return new CarTrafficDashboardDTO(getTraficInformation(account.getAddress().getAdressToString(), account.getWorkAddress().getAdressToString()), account.getAddress(), account.getWorkAddress());
    }
}
