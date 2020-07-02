package com.oc.p12.Entity;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class CarTravel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int id;

    @Column(name = "distance_home_work")
    private double distanceToWork;

    @Column(name = "normal_travel_time")
    private int normalTravelTimeToWork;

    @Column(name = "realtime_travel_time")
    private int realTimeTravelTimeToWork;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private Account account;

    @OneToOne
    @JoinColumn(name = "adress_id", referencedColumnName = "adress_id")
    private Adress workAdress;

    public CarTravel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDistanceToWork() {
        return distanceToWork;
    }

    public void setDistanceToWork(double distanceToWork) {
        this.distanceToWork = distanceToWork;
    }

    public int getNormalTravelTimeToWork() {
        return normalTravelTimeToWork;
    }

    public void setNormalTravelTimeToWork(int normalTravelTimeToWork) {
        this.normalTravelTimeToWork = normalTravelTimeToWork;
    }

    public int getRealTimeTravelTimeToWork() {
        return realTimeTravelTimeToWork;
    }

    public void setRealTimeTravelTimeToWork(int realTimeTravelTimeToWork) {
        this.realTimeTravelTimeToWork = realTimeTravelTimeToWork;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Adress getWorkAdress() {
        return workAdress;
    }

    public void setWorkAdress(Adress workAdress) {
        this.workAdress = workAdress;
    }
}
