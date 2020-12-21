package com.oc.p12.Repository;

import com.oc.p12.Entity.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdressRepository extends JpaRepository<Adress, Integer> {

    Adress findById (int id);

}
