package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.Account.AccountDto;
import com.oc.p12.Bean.Dto.AccountInfoDto;
import com.oc.p12.Bean.Dto.Adress.AdressDto;
import com.oc.p12.Bean.Dto.RegistrationDto;
import com.oc.p12.Bean.Dto.TransportRegistrationDto;
import com.oc.p12.Entity.Account;
import com.oc.p12.Entity.Address;
import com.oc.p12.Entity.TransportInfo;
import com.oc.p12.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
        dto.getAccount().setAddress( adressService.save(new Address(dto.getHomeAdress())));
        dto.getAccount().setWorkAddress(( adressService.save(new Address(dto.getWorkAdress()))));
        Account account = accountRepository.save(dto.getAccount());
        transportInfoService.save(new TransportInfo(dto.getTransportRegistrationDto(), account));
        return new AccountDto(accountRepository.save(dto.getAccount()));
    }

    public AccountDto update(RegistrationDto dto){
        /*adressService.save(new Adress(dto.getHomeAdress()));
        adressService.save(new Adress(dto.getWorkAdress()));*/
        dto.getAccount().setAddress( adressService.save(new Address(dto.getHomeAdress())));
        dto.getAccount().setWorkAddress(( adressService.save(new Address(dto.getWorkAdress()))));
        transportInfoService.save(new TransportInfo(dto.getTransportRegistrationDto()));
        return save(dto.getAccount());
    }


    public AccountDto save(Account account){
        System.out.println(account);
        if(account.getPassword().isEmpty()){
            System.out.println("Account Updated no Pass");
            account.setPassword(retrievePassword(account.getId()));
            return new AccountDto(accountRepository.save(account));
        } else {
            System.out.println("Account Updated with Pass");
            account.setPassword(passwordEncoder.encode(account.getPassword()));
            return new AccountDto(accountRepository.save(account));
        }
    }

    public AccountDto update(Account account){
        return new AccountDto(accountRepository.save(account));
    }


    public AccountInfoDto getMemberInfo(Integer id){
        AccountInfoDto dto = new AccountInfoDto();
        Account account = findById(id);
        dto.setAccount(new AccountDto(account));
        dto.setHomeAdress(new AdressDto(account.getAddress()));
        dto.setWorkAdress(new AdressDto(account.getWorkAddress()));
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

    public String retrievePassword(int id){
        return findById(id).getPassword();
    }
}
