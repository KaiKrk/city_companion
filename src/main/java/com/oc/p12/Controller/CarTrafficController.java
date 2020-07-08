package com.oc.p12.Controller;

import com.oc.p12.Bean.Dto.Account.AccountRequest;
import com.oc.p12.Bean.Dto.CarTraffic.CarTravelDto;
import com.oc.p12.Entity.Adress;
import com.oc.p12.Entity.CarTravel;
import com.oc.p12.Entity.CarTravelInfo;
import com.oc.p12.Service.AccountService;
import com.oc.p12.Service.AdressService;
import com.oc.p12.Service.CarTravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
public class CarTrafficController {

    @Autowired
    CarTravelService carTravelService;

    @Autowired
    AdressService adressService;

    @Autowired
    AccountService accountService;

    @PostMapping(name = "/saveCarTravel")
    public ResponseEntity<CarTravelDto> saveCarTravel(CarTravel carTravel){
       return new ResponseEntity<>(carTravelService.saveCarTravel(carTravel), HttpStatus.OK);
    }

    @PostMapping("/saveCarTravelInfo")
    public ResponseEntity<CarTravelInfo> saveCarTravelInfo(int accountId, Adress workAdress){
        Adress newAdress = adressService.save(workAdress);
        CarTravelInfo newCarTravelInfo = new CarTravelInfo(accountService.findById(accountId), newAdress);
        carTravelService.saveCarTravelInfo(newCarTravelInfo);
        return new ResponseEntity<>(newCarTravelInfo, HttpStatus.OK);
    }

    @PostMapping("/car/info")
    public ResponseEntity<CarTravelInfo> getCarTravelInfo(@RequestBody AccountRequest accountRequest){
        CarTravelInfo carTravelInfo = carTravelService.findCarTravelInfoByAccount(accountService.findById(accountRequest.getId()));
        return new ResponseEntity<>(carTravelInfo, HttpStatus.OK);
    }

    @PostMapping("/traffic")
    public ResponseEntity<CarTravelDto> getRealTimeCarTravelByMember(@RequestBody CarTravelInfo carTravelInfo){
        CarTravelDto carTravelDto = new CarTravelDto(carTravelService.getCarTravelByCarTravelInfo(carTravelInfo));
        return new ResponseEntity<>(carTravelDto, HttpStatus.OK);
    }

    @PostMapping("/traffic/now")
    public ResponseEntity fetchRealtimeTraffic(@RequestBody AccountRequest accountRequest){
        CarTravelInfo carTravelInfo = carTravelService.findCarTravelInfoByAccount(accountService.findById(accountRequest.getId()));
        carTravelService.fetchRealTimeTrafficByAccount(carTravelInfo);
        return new ResponseEntity(HttpStatus.OK);
    }
}
