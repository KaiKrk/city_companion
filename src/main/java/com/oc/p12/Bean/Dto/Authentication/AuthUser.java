package com.oc.p12.Bean.Dto.Authentication;

import lombok.Data;

@Data
public class AuthUser {
    private int id;
    private String email;
    private String surname;
    private String name;
    private String token;
    private String departureHour;

    public AuthUser() {
    }
}
