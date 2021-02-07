package com.oc.p12.Controller;

import com.oc.p12.Bean.Dto.Account.AccountDto;
import com.oc.p12.Bean.Dto.Account.AccountRequest;
import com.oc.p12.Bean.Dto.AccountInfoDto;
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

/**
 * Controller for Account Entity
 */
@CrossOrigin("*")
@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountService accountService;

    @Autowired
    AdressService adressService;

    @Autowired
    TransportInfoService transportInfoService;

    /**
     * method that register a new account
     * @param registrationDto
     * @return registrationDTO with HTTP Status
     */
    @PostMapping("/saveAccount")
    public ResponseEntity<RegistrationDto> saveAccount(@RequestBody RegistrationDto registrationDto){
        System.out.println(registrationDto);
        accountService.registration(registrationDto);
        return new ResponseEntity<>(new RegistrationDto(), HttpStatus.OK);
    }

    /**
     * method that updates an existing account
     * @param registrationDto
     * @return update account informations
     *
     */
    @PostMapping("/updateAccount")
    public ResponseEntity<RegistrationDto> updateAccount(@RequestBody RegistrationDto registrationDto){
        System.out.println(registrationDto.toString());
        accountService.update(registrationDto);
        return new ResponseEntity<>(new RegistrationDto(), HttpStatus.OK);
    }

    /**
     * method that retrieve an account
     * @param accountRequest
     * @return account of the user
     */
    @GetMapping("/myAccount")
    public ResponseEntity<AccountDto> getAccount(@RequestBody AccountRequest accountRequest){
        AccountDto accountDto = new AccountDto(accountRepository.findById(accountRequest.getId()));
        return new ResponseEntity<>(accountDto,HttpStatus.OK);
    }

    /**
     * method that retrieve an account
     * @param id
     * @return  account of the user
     */
    @GetMapping("/account")
    public ResponseEntity<AccountInfoDto> getAccountInfo(@RequestParam Integer id){
        AccountInfoDto dto = accountService.getMemberInfo(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
