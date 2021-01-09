package com.oc.p12.Repository;

import com.oc.p12.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Address, Integer> {

    Address findById (int id);

}
