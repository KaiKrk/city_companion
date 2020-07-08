package com.oc.p12.Entity;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;

@Entity
@Table(name = "car_journey_info")
public class CarTravelInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_journey_info_id")
    private int id;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id" )
    private Account account;

    @OneToOne
    @JoinColumn(name = "work_adress_id", referencedColumnName = "adress_id")
    private Adress workAdress;

    public CarTravelInfo() {
    }

    public CarTravelInfo(Account account, Adress workAdress){
        this.account = account;
        this.workAdress = workAdress;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
