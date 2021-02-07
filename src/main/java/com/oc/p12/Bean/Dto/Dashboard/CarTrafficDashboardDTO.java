package com.oc.p12.Bean.Dto.Dashboard;

import com.oc.p12.Bean.Dto.CarTraffic.CarTravelResponseDto;
import com.oc.p12.Entity.Adress;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CarTrafficDashboardDTO {

    public String address;
    public String destination;
    public String travelTime;
    public String estimatedTravelTime;


   public CarTrafficDashboardDTO(CarTravelResponseDto ctrd, Adress homeAddress, Adress workAddress){
        this.address = homeAddress.getAdressToString();
        this.destination = workAddress.getAdressToString();
        this.travelTime = ctrd.normalTrafficTime();
        this.estimatedTravelTime = ctrd.realTrafficTime();
    }

}
