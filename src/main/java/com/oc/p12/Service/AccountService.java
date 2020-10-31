package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.Account.AccountDto;
import com.oc.p12.Entity.Account;
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

    public Account findById(int id){
        Account account = accountRepository.findByAccountId(id);
        return  account;
    }


    public AccountDto save(Account account){
        System.out.println(account);
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return new AccountDto(accountRepository.save(account));
    }

    public void delete(int accountId){
        accountRepository.delete(accountRepository.findByAccountId(accountId));
    }

    public List<Account> findAccountByListIdAccount(List<Integer> idAccounts){
      return  accountRepository.findAccountByAccountIdIn(idAccounts);
    }

    public List<Account> getAccountByDepartureTime(String time){
        return accountRepository.findAccountByDepartureTime(time);
    }

    public Account findAccountByEmail(String email){
      return accountRepository.findAccountByEmail(email);
    }
}
