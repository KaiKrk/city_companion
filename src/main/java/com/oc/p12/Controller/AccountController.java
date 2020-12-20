package com.oc.p12.Controller;

import com.oc.p12.Bean.Dto.Account.AccountDto;
import com.oc.p12.Bean.Dto.Account.AccountRequest;
import com.oc.p12.Bean.Dto.RegistrationDto;
import com.oc.p12.Entity.Account;
import com.oc.p12.Entity.TransportInfo;
import com.oc.p12.Repository.AccountRepository;
import com.oc.p12.Service.AccountService;
import com.oc.p12.Service.AdressService;
import com.oc.p12.Service.TransportInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@CrossOrigin("*")
@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;
    //change encoder to service instead of controller and test again save account

    @Autowired
    AccountService accountService;

    @Autowired
    AdressService adressService;

    @Autowired
    TransportInfoService transportInfoService;


    @PostMapping("/saveAccount")
    public ResponseEntity<RegistrationDto> saveAccount(@RequestBody RegistrationDto registrationDto){
        System.out.println(registrationDto);
        return new ResponseEntity<>(new RegistrationDto(), HttpStatus.OK);
    }

    @PostMapping("/updateAccount")
    public ResponseEntity<RegistrationDto> updateAccount(@RequestBody RegistrationDto registrationDto){
        System.out.println(registrationDto);
        return new ResponseEntity<>(new RegistrationDto(), HttpStatus.OK);
    }

    @GetMapping("/myAccount")
    public ResponseEntity<AccountDto> getAccount(@RequestBody AccountRequest accountRequest){
        AccountDto accountDto = new AccountDto(accountRepository.findById(accountRequest.getId()));
        return new ResponseEntity<>(accountDto,HttpStatus.OK);
    }

    @GetMapping("/account")
    public ResponseEntity<RegistrationDto> getAccountInfo(@RequestParam Integer id){
        RegistrationDto dto = accountService.getMemberInfo(id);
        System.out.println(dto);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
