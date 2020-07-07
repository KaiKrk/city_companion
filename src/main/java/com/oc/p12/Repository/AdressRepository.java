package com.oc.p12.Repository;

import com.oc.p12.Entity.Account;
import com.oc.p12.Entity.Adress;
import com.oc.p12.Entity.CarTravel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Adress, Integer> {

    Adress findByAccount(Account accoung);

    Adress findByCarTravel(CarTravel carTravel);
}
