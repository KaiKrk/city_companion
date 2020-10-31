package com.oc.p12.Repository;

import com.oc.p12.Entity.Account;
import com.oc.p12.Entity.PublicTransportTravel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicTransportTravelRepository extends JpaRepository<PublicTransportTravel, Integer> {

    PublicTransportTravel findByAccount(Account account);

    List<PublicTransportTravel> findPublicTransportTravelsByAccountIn(List<Account> accounts);
}
