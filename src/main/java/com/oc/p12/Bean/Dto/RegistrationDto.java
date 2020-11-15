package com.oc.p12.Bean.Dto;

import com.oc.p12.Bean.Dto.Adress.AdressDto;
import com.oc.p12.Entity.Account;

public class RegistrationDto {

    public Account account;

    public AdressDto homeAdress;

    public AdressDto workAdress;

    public TransportRegistrationDto transportRegistrationDto;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public AdressDto getHomeAdress() {
        return homeAdress;
    }

    public void setHomeAdress(AdressDto homeAdress) {
        this.homeAdress = homeAdress;
    }

    public AdressDto getWorkAdress() {
        return workAdress;
    }

    public void setWorkAdress(AdressDto workAdress) {
        this.workAdress = workAdress;
    }

    public TransportRegistrationDto getTransportRegistrationDto() {
        return transportRegistrationDto;
    }

    public void setTransportRegistrationDto(TransportRegistrationDto transportRegistrationDto) {
        this.transportRegistrationDto = transportRegistrationDto;
    }
}
