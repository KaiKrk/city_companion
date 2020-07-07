package com.oc.p12.Controller;

import com.oc.p12.Bean.Dto.Adress.AdressDto;
import com.oc.p12.Bean.Dto.Adress.AdressRequest;
import com.oc.p12.Entity.Adress;
import com.oc.p12.Repository.AccountRepository;
import com.oc.p12.Repository.AdressRepository;
import com.oc.p12.Repository.CarTravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
public class AdressController {

    @Autowired
    AdressRepository adressRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CarTravelRepository carTravelRepository;

    @PostMapping("/saveAdress")
    public ResponseEntity<AdressDto> saveAdress(Adress adress){
        AdressDto adressDto = new AdressDto(adressRepository.save(adress));
        return new ResponseEntity<>(adressDto, HttpStatus.OK);
    }

    @GetMapping("/homeAdress")
    public ResponseEntity<AdressDto> getHomeAdress(@RequestBody AdressRequest adressRequest){
        AdressDto adressDto =  new AdressDto(adressRepository.findByAccount(accountRepository.findByAccountId(adressRequest.getAccountId())));
        return  new ResponseEntity<>(adressDto, HttpStatus.OK);
    }

    @GetMapping("/workAdress")
    public ResponseEntity<AdressDto> getWorkAdress(@RequestBody AdressRequest adressRequest){
        AdressDto adressDto =  new AdressDto(adressRepository.findByCarTravel(carTravelRepository.findById(adressRequest.getCarTravelId())));
        return new ResponseEntity<>(adressDto, HttpStatus.OK);
    }
}
