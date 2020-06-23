package com.oc.p12.Entity;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int account_id;

    private String email;

    private String name;

    private String password;

    @OneToOne
    @JoinColumn(name = "adress_id", referencedColumnName = "adress_id")
    private Adress adress;


}
