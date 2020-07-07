package com.oc.p12.Controller;

import com.oc.p12.Bean.Dto.Account.AccountDto;
import com.oc.p12.Bean.Dto.Account.AccountRequest;
import com.oc.p12.Entity.Account;
import com.oc.p12.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @PostMapping("/saveAccount")
    public ResponseEntity<AccountDto> saveAccount(Account account){
        AccountDto accountDto = new AccountDto(accountRepository.save(account));
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

    @GetMapping("/myAccount")
    public ResponseEntity<AccountDto> getAccount(@RequestBody AccountRequest accountRequest){
        AccountDto accountDto = new AccountDto(accountRepository.findByAccountId(accountRequest.getId()));
        return new ResponseEntity<>(accountDto,HttpStatus.OK);
    }
}
