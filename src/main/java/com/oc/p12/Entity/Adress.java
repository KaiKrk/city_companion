package com.oc.p12.Entity;

import javax.persistence.*;

@Entity
@Table(name = "adress")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adress_id")
    private int id;

    @OneToOne(mappedBy = "adress")
    private Account account;

    @OneToOne(mappedBy = "workAdress")
    private CarTravel carTravel;

    public Adress() {
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

    public CarTravel getCarTravel() {
        return carTravel;
    }

    public void setCarTravel(CarTravel carTravel) {
        this.carTravel = carTravel;
    }
}
