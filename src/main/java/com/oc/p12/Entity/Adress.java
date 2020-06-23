package com.oc.p12.Entity;

import javax.persistence.*;

@Entity
@Table(name = "adress")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "adress")
    private Account account;


}
