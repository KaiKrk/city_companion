package com.oc.p12.Entity;

import javax.persistence.*;

@Entity
@Table(name = "car_journey")
public class CarTravel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int id;

    @Column(name = "distance_home_work")
    private String distanceToWork;

    @Column(name = "normal_travel_time")
    private String normalTravelTimeToWork;

    @Column(name = "realtime_travel_time")
    private String realTimeTravelTimeToWork;

    @ManyToOne
    @JoinColumn(name = "car_journey_info", referencedColumnName = "car_journey_info_id")
    private CarTravelInfo carTravelInfo;

    public CarTravel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistanceToWork() {
        return distanceToWork;
    }

    public void setDistanceToWork(String distanceToWork) {
        this.distanceToWork = distanceToWork;
    }

    public String getNormalTravelTimeToWork() {
        return normalTravelTimeToWork;
    }

    public void setNormalTravelTimeToWork(String normalTravelTimeToWork) {
        this.normalTravelTimeToWork = normalTravelTimeToWork;
    }

    public String getRealTimeTravelTimeToWork() {
        return realTimeTravelTimeToWork;
    }

    public void setRealTimeTravelTimeToWork(String realTimeTravelTimeToWork) {
        this.realTimeTravelTimeToWork = realTimeTravelTimeToWork;
    }

    public CarTravelInfo getCarTravelInfo() {
        return carTravelInfo;
    }

    public void setCarTravelInfo(CarTravelInfo carTravelInfo) {
        this.carTravelInfo = carTravelInfo;
    }
}
