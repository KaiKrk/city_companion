package com.oc.p12.Entity;

import com.oc.p12.Bean.Dto.Adress.AdressDto;

import javax.persistence.*;

@Entity
@Table(name = "adress")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adress_id")
    private int id;

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

    public boolean isHomeAdress() {
        return isHomeAdress;
    }

    public void setHomeAdress(boolean homeAdress) {
        isHomeAdress = homeAdress;
    }

    public Adress() {
    }

  /*  public Adress(AdressDto dto) {
        this.streetNumber = dto.getStreetNumber();
        this.streetName = dto.getStreetName();
        this.city = dto.getCity();
        this.postalCode = dto.getPostalCode();
        this.isHomeAdress = dto.isHomeAddress;
    }*/

    public Adress(AdressDto dto) {
        this.id = dto.getId();
        this.streetNumber = dto.getStreetNumber();
        this.streetName = dto.getStreetName();
        this.city = dto.getCity();
        this.postalCode = dto.getPostalCode();
        this.isHomeAdress = dto.isHomeAddress;
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
