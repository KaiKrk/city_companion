package com.oc.p12.Bean.Dto;

import com.oc.p12.Bean.Dto.Account.AccountDto;
import com.oc.p12.Bean.Dto.Adress.AdressDto;

public class AccountInfoDto {

    public AccountDto account;

    public AdressDto homeAddress;

    public AdressDto workAddress;

    public TransportRegistrationDto transport;

    public AccountDto getAccount() {
        return account;
    }

    public void setAccount(AccountDto account) {
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
        return "AccountInfoDto{" +
                "account=" + account +
                ", homeAddress=" + homeAddress +
                ", workAddress=" + workAddress +
                ", transport=" + transport +
                '}';
    }
}
