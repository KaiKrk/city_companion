package com.oc.p12.Controller;

import com.oc.p12.Bean.Dto.Account.AccountRequest;
import com.oc.p12.Bean.Dto.Adress.AdressRequest;
import com.oc.p12.Bean.Dto.CarTraffic.CarTravelDto;
import com.oc.p12.Entity.Adress;
import com.oc.p12.Entity.CarTravel;
import com.oc.p12.Entity.TransportInfo;
import com.oc.p12.Service.AccountService;
import com.oc.p12.Service.AdressService;
import com.oc.p12.Service.CarTravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for Car Traffic Entity
 */
@CrossOrigin("http://localhost:4200")
@RestController
public class CarTrafficController {

    @Autowired
    CarTravelService carTravelService;

    @Autowired
    AdressService adressService;

    @Autowired
    AccountService accountService;

    /**
     * save car Travel
     * @param carTravel
     * @return
     */
    @PostMapping(name = "/saveCarTravel")
    public ResponseEntity<CarTravelDto> saveCarTravel(CarTravel carTravel){
       return new ResponseEntity<>(carTravelService.saveCarTravel(carTravel), HttpStatus.OK);
    }

    /**
     * Save account travel informations
     * @param adressRequest
     * @param workAddress
     * @return
     */
    @PostMapping("/saveCarTravelInfo")
    public ResponseEntity<TransportInfo> saveCarTravelInfo(AdressRequest adressRequest, Adress workAddress){
        Adress newAddress = adressService.save(workAddress);
        TransportInfo newTransportInfo = new TransportInfo(accountService.findById(adressRequest.getCarTravelId()), newAddress);
        carTravelService.saveCarTravelInfo(newTransportInfo);
        return new ResponseEntity<>(newTransportInfo, HttpStatus.OK);
    }

    /**
     * method that returns travel informations from account
     * @param accountRequest
     * @return get transport info
     */
    @PostMapping("/car/info")
    public ResponseEntity<TransportInfo> getCarTravelInfo(@RequestBody AccountRequest accountRequest){
        TransportInfo transportInfo = carTravelService.findCarTravelInfoByAccount(accountService.findById(accountRequest.getId()));
        return new ResponseEntity<>(transportInfo, HttpStatus.OK);
    }

    /**
     * get real time traffic informations by transprotInfo
     * @param transportInfo
     * @return the traffic information for a member
     */
    @PostMapping("/traffic")
    public ResponseEntity<CarTravelDto> getRealTimeCarTravelByMember(@RequestBody TransportInfo transportInfo){
        CarTravelDto carTravelDto = new CarTravelDto(carTravelService.getCarTravelByCarTravelInfo(transportInfo));
        return new ResponseEntity<>(carTravelDto, HttpStatus.OK);
    }

    /**
     * get real time traffic informations by account id
     * @param accountRequest
     * @return void
     */
    @PostMapping("/traffic/now")
    public ResponseEntity fetchRealtimeTraffic(@RequestBody AccountRequest accountRequest){
        TransportInfo transportInfo = carTravelService.findCarTravelInfoByAccount(accountService.findById(accountRequest.getId()));
        carTravelService.fetchRealTimeTrafficByAccount(transportInfo);
        return new ResponseEntity(HttpStatus.OK);
    }
}
