package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.Account.AccountDto;
import com.oc.p12.Entity.Account;
import com.oc.p12.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public AccountDto save(Account account){
        return new AccountDto(accountRepository.save(account));
    }

    public Account findById(int id){
        return accountRepository.findByAccountId(id);
    }
}
