package com.oc.p12.Repository;

import com.oc.p12.Entity.CarTravel;
import com.oc.p12.Entity.CarTravelInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarTravelRepository extends JpaRepository<CarTravel, Integer> {

    public CarTravel findById(int id);

    public CarTravel findByCarTravelInfo(CarTravelInfo carTravelInfo);
}
