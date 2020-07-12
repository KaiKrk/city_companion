package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.Account.AccountDto;
import com.oc.p12.Entity.Account;
import com.oc.p12.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    AccountRepository accountRepository;
    public AccountDto save(Account account){
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return new AccountDto(accountRepository.save(account));
    }

    public void delete(int accountId){
        accountRepository.delete(accountRepository.findByAccountId(accountId));
    }
}
