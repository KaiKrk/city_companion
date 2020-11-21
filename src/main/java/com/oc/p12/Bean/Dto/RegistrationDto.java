package com.oc.p12.Bean.Dto;

import com.oc.p12.Bean.Dto.Adress.AdressDto;
import com.oc.p12.Entity.Account;

public class RegistrationDto {

    public Account account;

    public AdressDto homeAddress;

    public AdressDto workAddress;

    public TransportRegistrationDto transport;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public AdressDto getHomeAdress() {
        return homeAddress;
    }

    public void setHomeAdress(AdressDto homeAdress) {
        this.homeAddress = homeAdress;
    }

    public AdressDto getWorkAdress() {
        return workAddress;
    }

    public void setWorkAdress(AdressDto workAdress) {
        this.workAddress = workAdress;
    }

    public TransportRegistrationDto getTransportRegistrationDto() {
        return transport;
    }

    public void setTransportRegistrationDto(TransportRegistrationDto transportRegistrationDto) {
        this.transport = transportRegistrationDto;
    }

    @Override
    public String toString() {
        return "RegistrationDto{" +
                "account=" + account +
                ", homeAdress=" + homeAddress +
                ", workAdress=" + workAddress +
                ", transportRegistrationDto=" + transport +
                '}';
    }
}
