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
    private CarTravelInfo carTravel;

    @Column(name = "house_number")
    public String streetNumber;

    @Column(name = "street_name")
    public String streetName;

    @Column(name = "city")
    public String city;

    @Column(name = "postal_code")
    public int postalCode;

    @Column(name = "is_home_adress")
    public boolean isHomeAdress;

    public Adress() {
    }

    public String getAdressToString(){
        return streetNumber+" "+streetName+" "+postalCode+" "+city;
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

    public CarTravelInfo getCarTravel() {
        return carTravel;
    }

    public void setCarTravel(CarTravelInfo carTravel) {
        this.carTravel = carTravel;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
}
