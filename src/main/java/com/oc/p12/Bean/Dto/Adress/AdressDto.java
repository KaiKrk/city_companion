package com.oc.p12.Bean.Dto.Adress;

import com.oc.p12.Entity.Adress;

import javax.persistence.Column;

public class AdressDto {

    public String streetNumber;
    public String streetName;
    public String city;
    public int postalCode;
    public boolean isHomeAdress;

    public AdressDto() {
    }

    public AdressDto(Adress adress) {
        this.streetNumber = adress.getStreetNumber();
        this.streetName = adress.getStreetName();
        this.city = adress.getCity();
        this.postalCode = adress.getPostalCode();
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
