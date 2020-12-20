package com.oc.p12.Repository;

import com.oc.p12.Entity.Account;
import com.oc.p12.Entity.TransportInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarTravelInfoRepository extends JpaRepository<TransportInfo,Integer> {

    public TransportInfo findByAccount(Account account );
}
