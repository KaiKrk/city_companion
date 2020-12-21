package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.Account.AccountDto;
import com.oc.p12.Bean.Dto.Adress.AdressDto;
import com.oc.p12.Bean.Dto.RegistrationDto;
import com.oc.p12.Bean.Dto.TransportRegistrationDto;
import com.oc.p12.Entity.Account;
import com.oc.p12.Entity.Adress;
import com.oc.p12.Entity.TransportInfo;
import com.oc.p12.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PublicTransportService publicTransportService;

    @Autowired
    AdressService adressService;

    @Autowired
    TransportInfoService transportInfoService;

    public Account findById(int id){
        Account account = accountRepository.findById(id);
        return  account;
    }

    public AccountDto registration(RegistrationDto dto){
        dto.getAccount().setPassword(passwordEncoder.encode( dto.getAccount().getPassword()));

        adressService.save(new Adress(dto.getWorkAdress()));
        dto.getAccount().setAdress( adressService.save(new Adress(dto.getHomeAdress())));
        dto.getAccount().setWorkAdress(( adressService.save(new Adress(dto.getWorkAdress()))));
        Account account = accountRepository.save(dto.getAccount());
        transportInfoService.save(new TransportInfo(dto.getTransportRegistrationDto(), account));
        return new AccountDto(accountRepository.save(dto.getAccount()));
    }


    public AccountDto save(Account account){
        System.out.println(account);
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return new AccountDto(accountRepository.save(account));
    }


    public RegistrationDto getMemberInfo(Integer id){
        RegistrationDto dto = new RegistrationDto();
        Account account = findById(id);
        dto.setAccount(account);
        dto.setHomeAdress(new AdressDto(account.getAdress()));
        dto.setWorkAdress(new AdressDto(account.getWorkAdress()));
        dto.setTransportRegistrationDto(new TransportRegistrationDto(transportInfoService.findByAccount(account)));
        return dto;
    }

    public void delete(int accountId){
        accountRepository.delete(accountRepository.findById(accountId));
    }

    public List<Account> getAccountByDepartureTime(String time){
        return accountRepository.findAccountByDepartureTime(time);
    }

    public Account findAccountByEmail(String email){
      return accountRepository.findAccountByEmail(email);
    }
}
