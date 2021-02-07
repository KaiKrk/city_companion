package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.Account.AccountDto;
import com.oc.p12.Entity.Account;
import com.oc.p12.Entity.Adress;
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
public class AdressServiceTest {

    @Autowired AdressService adressService;

    int adressId;
    int workAdressId;

    Adress testAdress = new Adress();
    Adress testWorkAdress = new Adress();
    @BeforeAll
    public void initAdress(){
     testAdress.setCity("Paris");
     testAdress.setHomeAdress(true);
     testAdress.setPostalCode(75013);
     testAdress.setStreetName("Rue Clisson");
     testAdress.setStreetNumber("40");

     testWorkAdress.setCity("Paris");
     testWorkAdress.setHomeAdress(false);
     testAdress.setPostalCode(75013);
     testAdress.setStreetName("Rue Clisson");
     testAdress.setStreetNumber("40");
    }

    @Test
    public void saveAdressTest(){
        Adress homeAdress =adressService.save(testAdress);
        Adress workAdress = adressService.save(testWorkAdress);
        adressId = homeAdress.getId();
        workAdressId = workAdress.getId();
        assertThat(homeAdress.getPostalCode() == 75013);
        assertThat(adressService.save(testWorkAdress).getAdressToString().equalsIgnoreCase("Rue Clisson"));
    }

    @AfterAll
    public void clearAdresses(){
        adressService.delete(adressId);
        adressService.delete(workAdressId);

    }
}
