package com.oc.p12.Bean;

import lombok.Data;

@Data
public class MailDetails {

    private  String myAccountEmail = "annalibraryoc@gmail.com";

    private  String password = "LibraryOCP7openclassrooms";

    private String subject = "Indicateur du jour";

    private String accountCreationSubject = " Bienvenue chez City Companion";

    private String accountCreationMessage = " Nous vous confirmons que votre compte a bien été crée avec succès";



    public String getSubject() {
        return subject;
    }
}
