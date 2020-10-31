package com.oc.p12.Bean.Dto.Account;

import com.oc.p12.Entity.Account;

import java.time.LocalTime;

public class AccountDto {

    private int id;

    private String email;

    private String name;

    private String surname;

    private String departureTime;

    public AccountDto(Account account) {
        this.id = account.getAccountId();
        this.email = account.getEmail();
        this.name = account.getName();
        this.surname = account.getSurname();
        this.departureTime = account.getDepartureTime();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }



}
