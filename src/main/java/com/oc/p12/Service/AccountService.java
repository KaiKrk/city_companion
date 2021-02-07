package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.Account.AccountDto;
import com.oc.p12.Bean.Dto.AccountInfoDto;
import com.oc.p12.Bean.Dto.Adress.AdressDto;
import com.oc.p12.Bean.Dto.RegistrationDto;
import com.oc.p12.Bean.Dto.TransportRegistrationDto;
import com.oc.p12.Entity.Account;
import com.oc.p12.Entity.Adress;
import com.oc.p12.Entity.TransportInfo;
import com.oc.p12.Repository.AccountRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for account entity
 */
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

    @Autowired
    EmailService emailService;

    /**
     * get Account by id
     * @param id
     * @return Account
     */
    public Account findById(int id){
        Account account = accountRepository.findById(id);
        return  account;
    }

    /**
     * register a new account
     * @param dto
     * @return AccountDto
     */
    @SneakyThrows
    public AccountDto registration(RegistrationDto dto){
        dto.getAccount().setPassword(passwordEncoder.encode( dto.getAccount().getPassword()));
        dto.getAccount().setAddress( adressService.save(new Adress(dto.getHomeAdress())));
        dto.getAccount().setWorkAddress(( adressService.save(new Adress(dto.getWorkAdress()))));
        Account account = accountRepository.save(dto.getAccount());
        transportInfoService.save(new TransportInfo(dto.getTransportRegistrationDto(), account));

        emailService.sendAccountCreationSuccessMail(dto.getAccount().getEmail());
        return new AccountDto(accountRepository.save(dto.getAccount()));
    }

    /**
     * update an existing account
     * @param dto
     * @return updated AccountDTO
     */
    public AccountDto update(RegistrationDto dto){
        dto.getAccount().setAddress( adressService.save(new Adress(dto.getHomeAdress())));
        dto.getAccount().setWorkAddress(( adressService.save(new Adress(dto.getWorkAdress()))));
        transportInfoService.save(new TransportInfo(dto.getTransportRegistrationDto()));
        return save(dto.getAccount());
    }

    /**
     * method that saves the account in database
     * @param account
     * @return save account in DTO
     */
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

    /**
     * method that retrieves account informations
     * @param id
     * @return get Member informations DTO
     */
    public AccountInfoDto getMemberInfo(Integer id){
        AccountInfoDto dto = new AccountInfoDto();
        Account account = findById(id);
        dto.setAccount(new AccountDto(account));
        dto.setHomeAdress(new AdressDto(account.getAddress()));
        dto.setWorkAdress(new AdressDto(account.getWorkAddress()));
        dto.setTransportRegistrationDto(new TransportRegistrationDto(transportInfoService.findByAccount(account)));
        return dto;
    }

    /**
     * delete account by id
     * @param accountId
     */
    public void delete(int accountId){
        accountRepository.delete(accountRepository.findById(accountId));
    }

    /**
     * return accounts by their departure time
     *
     * @param time
     * @return list of accounts that departure time is @param time
     */
    public List<Account> getAccountByDepartureTime(String time){
        return accountRepository.findAccountByDepartureTime(time);
    }

    /**
     * return account by email
     * @param email
     * @return accunt
     */
    public Account findAccountByEmail(String email){
      return accountRepository.findAccountByEmail(email);
    }

    /**
     * method that return the encrypted password of an account by it's id
     * @param id
     * @return
     */
    public String retrievePassword(int id){
        return findById(id).getPassword();
    }
}
