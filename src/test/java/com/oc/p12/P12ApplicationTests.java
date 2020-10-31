package com.oc.p12;

import com.oc.p12.Bean.Dto.Adress.AdressRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
class P12ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        String time = LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME).substring(0,8);
        System.out.println(time);
    }

}
