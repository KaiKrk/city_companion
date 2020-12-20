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

@CrossOrigin("http://localhost:4200")
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
    public ResponseEntity<TransportInfo> saveCarTravelInfo(AdressRequest adressRequest, Adress workAdress){
        Adress newAdress = adressService.save(workAdress);
        TransportInfo newTransportInfo = new TransportInfo(accountService.findById(adressRequest.getCarTravelId()), newAdress);
        carTravelService.saveCarTravelInfo(newTransportInfo);
        return new ResponseEntity<>(newTransportInfo, HttpStatus.OK);
    }

    @PostMapping("/car/info")
    public ResponseEntity<TransportInfo> getCarTravelInfo(@RequestBody AccountRequest accountRequest){
        TransportInfo transportInfo = carTravelService.findCarTravelInfoByAccount(accountService.findById(accountRequest.getId()));
        return new ResponseEntity<>(transportInfo, HttpStatus.OK);
    }

    @PostMapping("/traffic")
    public ResponseEntity<CarTravelDto> getRealTimeCarTravelByMember(@RequestBody TransportInfo transportInfo){
        CarTravelDto carTravelDto = new CarTravelDto(carTravelService.getCarTravelByCarTravelInfo(transportInfo));
        return new ResponseEntity<>(carTravelDto, HttpStatus.OK);
    }

    @PostMapping("/traffic/now")
    public ResponseEntity fetchRealtimeTraffic(@RequestBody AccountRequest accountRequest){
        TransportInfo transportInfo = carTravelService.findCarTravelInfoByAccount(accountService.findById(accountRequest.getId()));
        carTravelService.fetchRealTimeTrafficByAccount(transportInfo);
        return new ResponseEntity(HttpStatus.OK);
    }
}
