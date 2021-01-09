package com.oc.p12.Entity;

import com.oc.p12.Bean.Dto.Account.AccountDto;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "adress_id", referencedColumnName = "adress_id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "work_adress_id", referencedColumnName = "adress_id")
    private Address workAddress;

    @Column(name = "departure_time")
    private String departureTime;

    public Account() {
    }

    public Account(AccountDto dto) {
        this.id = dto.getId();
        this.surname = dto.getSurname();
        this.name = dto.getName();
        this.email = dto.getEmail();
        this.departureTime = dto.getDepartureTime();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
    }

    public int getAccountId() {
        return id;
    }

    public void setAccountId(int account_id) {
        this.id = account_id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", adress=" + address +
                ", workAdress=" + workAddress +
                ", departureTime='" + departureTime + '\'' +
                '}';
    }
}
