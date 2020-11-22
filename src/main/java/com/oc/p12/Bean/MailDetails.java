package com.oc.p12.Bean;

import lombok.Data;

@Data
public class MailDetails {

    private  String myAccountEmail = "annalibraryoc@gmail.com";

    private  String password = "LibraryOCP7openclassrooms";

    private String subject = "Indicateur du jour";





    public String getSubject() {
        return subject;
    }
}
