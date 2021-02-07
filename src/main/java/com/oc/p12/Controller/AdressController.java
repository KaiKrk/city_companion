package com.oc.p12.Controller;

import com.oc.p12.Bean.Dto.Adress.AdressDto;
import com.oc.p12.Bean.Dto.Adress.AdressRequest;
import com.oc.p12.Entity.Account;
import com.oc.p12.Entity.Adress;
import com.oc.p12.Repository.AccountRepository;
import com.oc.p12.Repository.AdressRepository;
import com.oc.p12.Repository.CarTravelRepository;
import com.oc.p12.Service.AccountService;
import com.oc.p12.Service.CarTravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for Adress entity
 */
@CrossOrigin("http://localhost:4200")
@RestController
public class AdressController {

    @Autowired
    AdressRepository adressRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountService accountService;

    @Autowired
    CarTravelService carTravelService;

    @Autowired
    CarTravelRepository carTravelRepository;

    /**
     * method that saves and link a new Adress to Account
     * @param address
     * @param adressRequest
     * @return save account dto
     */
    @PostMapping("/saveAdress")
    public ResponseEntity<AdressDto> saveAdress(@RequestBody Adress address, AdressRequest adressRequest){
        AdressDto adressDto = new AdressDto(adressRepository.save(address));
            Account account = accountService.findById(adressRequest.getAccountId());
            account.setAddress(address);
            accountService.save(account);
        return new ResponseEntity<>(adressDto, HttpStatus.OK);
    }

    /**
     * get Account home adress
     * @param adressRequest
     * @return home adress dto
     */
    @GetMapping("/homeAdress")
    public ResponseEntity<AdressDto> getHomeAdress(@RequestBody AdressRequest adressRequest){
        AdressDto adressDto =  new AdressDto(accountRepository.findById(adressRequest.getAccountId()).getAddress());
        return  new ResponseEntity<>(adressDto, HttpStatus.OK);
    }

    /**
     * get Account work adress
     * @param adressRequest
     * @return work adress dto
     */
    @GetMapping("/workAdress")
    public ResponseEntity<AdressDto> getWorkAdress(@RequestBody AdressRequest adressRequest){
        AdressDto adressDto =  new AdressDto(accountRepository.findById(adressRequest.getAccountId()).getWorkAddress())
;        return new ResponseEntity<>(adressDto, HttpStatus.OK);
    }
}
