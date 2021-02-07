package com.oc.p12.Bean.Dto.Adress;

import com.oc.p12.Entity.Adress;

public class AdressDto {

    public int id;
    public String streetNumber;
    public String streetName;
    public String city;
    public int postalCode;
    public boolean isHomeAddress;

    public AdressDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isHomeAddress() {
        return isHomeAddress;
    }

    public void setHomeAddress(boolean homeAddress) {
        isHomeAddress = homeAddress;
    }

    public AdressDto(Adress address) {
        this.id = address.getId();
        this.streetNumber = address.getStreetNumber();
        this.streetName = address.getStreetName();
        this.city = address.getCity();
        this.postalCode = address.getPostalCode();
        this.isHomeAddress =  address.isHomeAdress();
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

    @Override
    public String toString() {
        return "AdressDto{" +
                "id=" + id +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", postalCode=" + postalCode +
                ", isHomeAddress=" + isHomeAddress +
                '}';
    }

    public boolean isHomeAdress() {
        return isHomeAddress;
    }

    public void setHomeAdress(boolean homeAdress) {
        isHomeAddress = homeAdress;
    }
}
