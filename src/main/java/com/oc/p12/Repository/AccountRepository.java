package com.oc.p12.Repository;

import com.oc.p12.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findByAccountId(int id);

    Account findByEmail(String email);

}
