package com.oc.p12.Repository;

import com.oc.p12.Entity.Account;
import com.oc.p12.Entity.CarTravelInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarTravelInfoRepository extends JpaRepository<CarTravelInfo,Integer> {

    public CarTravelInfo findByAccount(Account account );
}
