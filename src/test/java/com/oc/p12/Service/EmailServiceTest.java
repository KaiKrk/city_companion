package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.Account.AccountDto;
import com.oc.p12.Entity.Account;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class EmailServiceTest {

    @Autowired
    EmailService emailService;

    @Test
    public void sendEmailTest() throws Exception {
        emailService.sendEmailDailyInformations("testemailcitycompanion@yopmail.com", 19);
    }
}
