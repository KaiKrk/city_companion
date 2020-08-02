package com.oc.p12;

import com.oc.p12.Bean.Dto.Adress.AdressRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class P12ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        AdressRequest adressRequest = new AdressRequest();
        adressRequest.setAccountId(1);
        System.out.println(adressRequest);
    }

}
