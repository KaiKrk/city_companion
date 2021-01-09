package com.oc.p12.Bean.Dto.Dashboard;

import com.oc.p12.Bean.Dto.CarTraffic.CarTravelResponseDto;
import com.oc.p12.Entity.Address;

public class CarTrafficDashboardDTO {

    public String adress;
    public String destination;
    public String travelTime;
    public String estimatedTravelTime;


   public CarTrafficDashboardDTO(CarTravelResponseDto ctrd, Address homeAddress, Address workAddress){
        this.adress = homeAddress.getAdressToString();
        this.destination = workAddress.getAdressToString();
        this.travelTime = ctrd.normalTrafficTime();
        this.estimatedTravelTime = ctrd.realTrafficTime();
    }

}
