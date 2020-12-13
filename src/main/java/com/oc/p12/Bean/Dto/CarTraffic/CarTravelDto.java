package com.oc.p12.Bean.Dto.CarTraffic;

import com.oc.p12.Entity.CarTravel;

public class CarTravelDto {

    public String distance;

    public String estimatedTravelTime;

    public String realTimeTravelTime;

    public CarTravelDto() {
    }

    public CarTravelDto(CarTravel carTravel){
        this.distance = carTravel.getDistanceToWork();
        this.estimatedTravelTime = carTravel.getNormalTravelTimeToWork();
        this.realTimeTravelTime = carTravel.getRealTimeTravelTimeToWork();
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getEstimatedTravelTime() {
        return estimatedTravelTime;
    }

    public void setEstimatedTravelTime(String estimatedTravelTime) {
        this.estimatedTravelTime = estimatedTravelTime;
    }

    public String getRealTimeTravelTime() {
        return realTimeTravelTime;
    }

    public void setRealTimeTravelTime(String realTimeTravelTime) {
        this.realTimeTravelTime = realTimeTravelTime;
    }
}
