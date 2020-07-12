package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.Account.AccountDto;
import com.oc.p12.Entity.Account;
import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;
import java.time.LocalTime;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class AccountServiceTest {

    @Autowired
    AccountService accountService;

    Account testAccount = new Account();
    @BeforeAll
    public void initAccount(){
        testAccount.setEmail("adamp12@yopmail.com");
        testAccount.setPassword("123");
        testAccount.setDepartureTime(LocalTime.NOON);
        testAccount.setName("Adam");
        testAccount.setSurname("Johnson");
    }

    @Test
    public void saveAccountTest(){
       AccountDto account = accountService.save(testAccount);
       testAccount.setAccountId(account.getId());
       assertThat(account.getEmail()).isEqualTo(testAccount.getEmail());
    }

    @AfterAll
    public void deleteTestAccount(){
    accountService.delete(testAccount.getAccountId());
    }
}
